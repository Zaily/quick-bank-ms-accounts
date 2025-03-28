package com.quickbank.accounts.application.payload;

import com.quickbank.accounts.application.util.InformationPayload;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
public class CreateAccountInformationPayload implements InformationPayload, Serializable {

    private CreateAccountPayload account;

    public CreateAccountPayload getAccount() {
        if(account == null)
            account = new CreateAccountPayload();
        return account;
    }
}
