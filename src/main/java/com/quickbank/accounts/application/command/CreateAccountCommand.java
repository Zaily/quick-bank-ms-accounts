package com.quickbank.accounts.application.command;

import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
public class CreateAccountCommand implements Command, Serializable {

    private String ownerId;
    private String accountType;
    private String currency;
}
