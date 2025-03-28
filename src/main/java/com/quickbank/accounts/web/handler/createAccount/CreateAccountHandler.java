package com.quickbank.accounts.web.handler.createAccount;

import com.quickbank.accounts.application.command.CreateAccountCommand;
import com.quickbank.accounts.application.service.TimeManagerService;
import com.quickbank.accounts.application.usecase.createAccount.CreateAccountUseCase;
import com.quickbank.accounts.web.dto.response.error.mapper.ErrorResponseMapper;
import com.quickbank.accounts.web.handler.ResponseBuilder;
import com.quickbank.accounts.web.handler.createAccount.mapper.CreateAccountMapper;
import com.quickbank.accounts.web.handler.error.ErrorHandler;
import com.quickbank.accounts.web.util.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class CreateAccountHandler {

    private final CreateAccountUseCase useCase;
    private final TimeManagerService timeManagerService;

    public Mono<ResponseEntity<GenericResponse>> execute(
            String ownerId,
            String accountType,
            String currency
    ){
        return Mono.just(
                    useCase.execute(buildCommand(ownerId,accountType,currency))
                            .fold(ErrorResponseMapper::useCaseToErrorResponse, CreateAccountMapper::informationToResponse)
                )
                .map(genericResponse -> new ResponseBuilder().mapResponseBuilder(genericResponse, HttpStatus.CREATED))
                .switchIfEmpty(Mono.just(ResponseEntity.noContent().build()))
                .onErrorResume(error -> ErrorHandler.handlerError(error, timeManagerService.getInstantIsoFormat() ) );

    }

    private CreateAccountCommand buildCommand(
            String ownerId,
            String accountType,
            String currency
    ){
        return CreateAccountMapper.requestToCommand(ownerId, accountType, currency);
    }
}
