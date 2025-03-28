package com.quickbank.accounts.application.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
public class MessageObjectInfoResponse implements Serializable {

    private String responseCode;
    private String responseMessage;
    private String responseDetails;
}
