package com.quickbank.accounts.web.dto.response;

import com.quickbank.accounts.web.util.GenericResponse;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class CreateAccountResponse implements GenericResponse, Serializable {

    private String accountId;
    private String ownerId;
    private String accountType;
    private String currency;
    private String status;
    private String createdDateTime;
}
