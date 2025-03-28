package com.quickbank.accounts.application.payload;

import com.quickbank.accounts.application.util.AbstractInformationResponse;
import com.quickbank.accounts.application.util.HeaderObjectInfoResponse;
import com.quickbank.accounts.application.util.MessageObjectInfoResponse;

public class CreateAccountInformation extends AbstractInformationResponse<CreateAccountInformationPayload> {

    public CreateAccountInformation(HeaderObjectInfoResponse header, MessageObjectInfoResponse message, CreateAccountInformationPayload data){
        super(header, message, data);
    }
}
