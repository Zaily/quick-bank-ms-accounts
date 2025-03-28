package com.quickbank.accounts.config;

import com.quickbank.accounts.application.port.AccountPort;
import com.quickbank.accounts.application.service.AccountService;
import com.quickbank.accounts.application.service.TimeManagerService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {

    @Bean
    public TimeManagerService timeManagerService() {
        return new TimeManagerService();
    }

    @Bean
    public AccountService accountService(AccountPort port){
        return new AccountService(port);
    }
}
