package com.quickbank.accounts.application.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
public class ErrorResponseInfoDetail implements Serializable {

    private String errorCode;
    private String errorDetail;
}
