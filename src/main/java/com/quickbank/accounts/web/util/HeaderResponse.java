package com.quickbank.accounts.web.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class HeaderResponse {

    private Integer httpStatusCode;
    private String httpStatusDesc;
    private String requestDateTime;
}
