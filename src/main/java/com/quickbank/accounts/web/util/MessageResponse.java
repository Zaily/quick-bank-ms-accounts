package com.quickbank.accounts.web.util;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MessageResponse {

    private String responseCode;
    private String responseMessage;
    private String responseDetails;

}