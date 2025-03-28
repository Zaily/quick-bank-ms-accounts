package com.quickbank.accounts.config;

import com.quickbank.accounts.application.service.TimeManagerService;
import com.quickbank.accounts.application.usecase.createAccount.CreateAccountUseCase;
import com.quickbank.accounts.web.handler.createAccount.CreateAccountHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {

    @Bean
    public CreateAccountHandler createAccountHandler(CreateAccountUseCase useCase, TimeManagerService timeManagerService){
        return new CreateAccountHandler(useCase, timeManagerService);
    }

}
