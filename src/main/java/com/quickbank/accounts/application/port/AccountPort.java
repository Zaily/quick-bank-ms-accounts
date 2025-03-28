package com.quickbank.accounts.application.port;

import com.quickbank.accounts.application.payload.dto.CreateAccountDto;
import reactor.core.publisher.Mono;

public interface AccountPort {
    Mono<CreateAccountDto> createAccount( CreateAccountDto accountDto);

}
