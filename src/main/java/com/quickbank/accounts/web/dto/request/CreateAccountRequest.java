package com.quickbank.accounts.web.dto.request;

import lombok.*;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class CreateAccountRequest implements Serializable {

    private String ownerId;
    private String accountType;
    private String currency;
}
