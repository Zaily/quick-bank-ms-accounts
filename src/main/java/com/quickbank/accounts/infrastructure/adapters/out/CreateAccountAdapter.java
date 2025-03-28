package com.quickbank.accounts.infrastructure.adapters.out;

import com.quickbank.accounts.application.payload.dto.CreateAccountDto;
import com.quickbank.accounts.application.port.AccountPort;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Mono;

import java.util.Objects;
import java.util.UUID;

@Slf4j
public class CreateAccountAdapter implements AccountPort {

    private static final String STATE_ACTIVE = "ACTIVE";

    @Override
    public Mono<CreateAccountDto> createAccount(CreateAccountDto accountDto) {
        return Mono.just(Objects.requireNonNull(createAccountOut(accountDto)))
                .doOnSuccess(m -> log.info("AccountPort.createAccount, Success"))
                .doOnError(e -> log.error("AccountPort.createAccount, Error creating account, detail: {},", e.getMessage()))
                .onErrorResume(error -> Mono.error(new RuntimeException(error.getMessage())));
    }

    private CreateAccountDto createAccountOut(CreateAccountDto accountDto){
    //TO-DO: al crear la BD se puede hacer el repository.save
        /*
            return Mono.just(accountRepository.save(CreateAccountAdapter.dtoToEntity(accountDto)))
                .map(CreateAccountAdapter::entityToDto)
                .doOnSuccess(m -> log.info("CreateAccountAdapter.createAccountOut, ownerId: [{}]", accountDto.getOwnerId()))
                .onErrorResume(e -> Mono.error(new RuntimeException("There was errors trying create an Account")));
         */
        log.info("CreateAccountAdapter.createAccountOut, Account Created, time: {},", accountDto.getCreatedDateTime());
        return accountDto;
    }
}
