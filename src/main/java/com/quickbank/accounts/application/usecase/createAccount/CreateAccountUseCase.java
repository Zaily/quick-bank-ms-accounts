package com.quickbank.accounts.application.usecase.createAccount;

import com.quickbank.accounts.application.command.CreateAccountCommand;
import com.quickbank.accounts.application.error.UseCaseErrorResponse;
import com.quickbank.accounts.application.payload.CreateAccountInformation;
import com.quickbank.accounts.application.service.AccountService;
import com.quickbank.accounts.application.service.TimeManagerService;
import com.quickbank.accounts.application.usecase.UseCase;
import com.quickbank.accounts.application.usecase.createAccount.mapper.CreateAccountUseCaseMapper;
import com.quickbank.accounts.application.util.GenericResponseCodes;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
@Slf4j
public class CreateAccountUseCase implements UseCase<CreateAccountCommand, Either<UseCaseErrorResponse, CreateAccountInformation>> {

    private final TimeManagerService timeManagerService;
    private final AccountService accountService;
    private static final String STATE_ACTIVE = "ACTIVE";


    @Override
    public Either<UseCaseErrorResponse, CreateAccountInformation> execute(CreateAccountCommand command) {
        log.info("CreateAccountUseCase.execute: ownerId:{},", command.getOwnerId());

        Either<Throwable, CreateAccountInformation> response =
                Try.of(() -> accountService.createAccount(
                        CreateAccountUseCaseMapper.commandtoCreateAccountDto(
                                command.getOwnerId(),
                                command.getAccountType(),
                                command.getCurrency(),
                                STATE_ACTIVE,
                                timeManagerService.getInstantIsoFormat()
                            )
                        )
                ).map(accountCreate -> {
                    if(accountCreate.isSuccess() && accountCreate.getPayload().isPresent()){

                        return CreateAccountUseCaseMapper.buildSuccessResponse(
                                HttpStatus.CREATED,
                                timeManagerService.getInstantIsoFormat(),
                                GenericResponseCodes.TRANSACCION_EXITOSA,
                                accountCreate.getResponseMessage(),
                                accountCreate.getPayload().get());
                    } else {
                        throw new RuntimeException(accountCreate.getResponseMessage());
                    }
                })
                .onFailure(e -> new RuntimeException(e.getMessage()))
                .toEither();

        return response.isRight() ?
                Either.right(response.get()) :
                Either.left(CreateAccountUseCaseMapper.buildErrorResponse(
                        timeManagerService.getInstantIsoFormat(),
                        HttpStatus.CONFLICT,
                        GenericResponseCodes.TRANSACCION_FALLIDA,
                        response.getLeft().getMessage()));
    }
}
