package com.quickbank.accounts.domain.entity;

import lombok.*;

import java.io.Serializable;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AccountEntity implements Serializable {

    private String accountId;
    private String ownerId;
    private String accountType;
    private String currency;
    private String status;
    private String createdDateTime;
}
