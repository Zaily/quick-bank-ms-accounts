package com.quickbank.accounts.application.error;

import com.quickbank.accounts.application.util.HeaderObjectInfoResponse;
import com.quickbank.accounts.application.util.MessageObjectInfoResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
public class UseCaseErrorResponse extends Exception{

    private HeaderObjectInfoResponse headers;
    private MessageObjectInfoResponse messageResponse;
    private List<ErrorResponseInfoDetail> errors;

    public UseCaseErrorResponse(HeaderObjectInfoResponse headers, MessageObjectInfoResponse messageResponse, ErrorResponseInfoDetail error) {
        this.headers = headers;
        this.messageResponse = messageResponse;
        errors = getErrors();
        errors.add(error);
    }

    public List<ErrorResponseInfoDetail> getErrors(){
        if (this.errors == null)
            return new ArrayList<ErrorResponseInfoDetail>();
        return errors;
    }
}
