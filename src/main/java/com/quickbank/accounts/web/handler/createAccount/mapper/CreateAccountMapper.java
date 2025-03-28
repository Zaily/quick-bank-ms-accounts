package com.quickbank.accounts.web.handler.createAccount.mapper;

import com.quickbank.accounts.application.command.CreateAccountCommand;
import com.quickbank.accounts.application.payload.CreateAccountInformation;
import com.quickbank.accounts.web.dto.response.CreateAccountResponse;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CreateAccountMapper {

    public static CreateAccountCommand requestToCommand(
            String ownerId,
            String accountType,
            String currency
    ){
        return CreateAccountCommand.builder()
                .ownerId(ownerId)
                .accountType(accountType)
                .currency(currency)
                .build();

    }

    public static CreateAccountResponse informationToResponse(CreateAccountInformation accountInformation){
        return CreateAccountResponse.builder()
                .accountId(accountInformation.getData().getAccount().getAccountId())
                .accountType(accountInformation.getData().getAccount().getAccountType())
                .ownerId(accountInformation.getData().getAccount().getOwnerId())
                .currency(accountInformation.getData().getAccount().getCurrency())
                .status(accountInformation.getData().getAccount().getStatus())
                .createdDateTime(accountInformation.getData().getAccount().getCreatedDateTime())
                .build();
    }
}
