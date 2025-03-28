package com.quickbank.accounts.config;

import com.quickbank.accounts.application.service.AccountService;
import com.quickbank.accounts.application.service.TimeManagerService;
import com.quickbank.accounts.application.usecase.createAccount.CreateAccountUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UseCaseConfig {

    @Bean
    public CreateAccountUseCase createAccountUseCase(TimeManagerService timeManagerService, AccountService accountService){
        return new CreateAccountUseCase(timeManagerService, accountService);
    }
}
