package com.quickbank.accounts.application.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Getter
@Builder
@AllArgsConstructor
public class AbstractInformationResponse<T extends InformationPayload> implements Serializable {

    private HeaderObjectInfoResponse headers;
    private MessageObjectInfoResponse messageResponse;
    private T data;
}
