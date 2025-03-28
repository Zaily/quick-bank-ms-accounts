package com.quickbank.accounts.config;

import com.quickbank.accounts.application.port.AccountPort;
import com.quickbank.accounts.infrastructure.adapters.out.CreateAccountAdapter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortConfig {

    @Bean
    public AccountPort accountPort(){
        return new CreateAccountAdapter();
    }
}
