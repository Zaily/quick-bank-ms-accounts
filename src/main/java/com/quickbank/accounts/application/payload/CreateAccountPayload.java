package com.quickbank.accounts.application.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateAccountPayload {

    private String accountId;
    private String ownerId;
    private String accountType;
    private String currency;
    private String status;
    private String createdDateTime;
}
