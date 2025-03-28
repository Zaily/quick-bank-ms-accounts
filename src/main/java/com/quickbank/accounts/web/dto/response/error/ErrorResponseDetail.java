package com.quickbank.accounts.web.dto.response.error;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponseDetail implements Serializable {

    private String errorCode;
    private String errorDetail;
}
