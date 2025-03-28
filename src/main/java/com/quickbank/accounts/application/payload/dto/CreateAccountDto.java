package com.quickbank.accounts.application.payload.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Builder
@Getter
public class CreateAccountDto implements Serializable {

    private String accountId;
    private String ownerId;
    private String accountType;
    private String currency;
    private String status;
    private String createdDateTime;
}
