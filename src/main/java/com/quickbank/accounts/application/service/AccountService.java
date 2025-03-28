package com.quickbank.accounts.application.service;

import com.quickbank.accounts.application.payload.CreateAccountInformation;
import com.quickbank.accounts.application.payload.dto.CreateAccountDto;
import com.quickbank.accounts.application.port.AccountPort;
import com.quickbank.accounts.application.util.AbstractVo;
import io.vavr.control.Either;
import io.vavr.control.Try;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public class AccountService {

    private final AccountPort accountPort;

    public AbstractVo<CreateAccountDto> createAccount(CreateAccountDto accountDto
    ){
        log.info("AccountService.createAccount");

        Either<Throwable, AbstractVo<CreateAccountDto>> response =
                Try.of(() -> accountPort.createAccount(accountDto)
                        .doOnSuccess(m -> log.info("AccountService.createAccount, Success"))
                        .doOnError(e -> log.error("Error creating account, ownerId: {}, details:{}", accountDto.getOwnerId(), e.getMessage()))
                        .onErrorResume(Mono::error)
                        .block()
                )
                .map(account -> new AbstractVo<>(Optional.of(account), "Account does created"))
                .onSuccess(m -> log.info("Transaction create account Success"))
                .onFailure(error -> log.error("AccountService.createAccount, ownerId: {}, errorMessage: {}",accountDto.getOwnerId(), error.getMessage()))
                .toEither();

        return response.isRight() ?
                response.get() :
                new AbstractVo<>(Optional.empty(), "Account does not created.");
    }

}
