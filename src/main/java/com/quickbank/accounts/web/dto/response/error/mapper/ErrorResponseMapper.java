package com.quickbank.accounts.web.dto.response.error.mapper;

import com.quickbank.accounts.application.error.UseCaseErrorResponse;
import com.quickbank.accounts.web.dto.response.error.ErrorResponse;
import com.quickbank.accounts.web.dto.response.error.ErrorResponseDetail;
import com.quickbank.accounts.web.util.HeaderResponse;
import com.quickbank.accounts.web.util.MessageResponse;
import lombok.experimental.UtilityClass;

import java.util.stream.Collectors;

@UtilityClass
public class ErrorResponseMapper {

    public static ErrorResponse useCaseToErrorResponse(UseCaseErrorResponse error){
        return ErrorResponse.builder()
                .headers(
                        HeaderResponse.builder()
                                .httpStatusCode(error.getHeaders().getHttpStatusCode())
                                .httpStatusDesc(error.getHeaders().getHttpStatusDesc())
                                .requestDateTime(error.getHeaders().getRequestDateTime())
                                .build()
                )
                .messageResponse(
                        MessageResponse.builder()
                                .responseCode(error.getMessageResponse().getResponseCode())
                                .responseDetails(error.getMessageResponse().getResponseDetails())
                                .responseMessage(error.getMessageResponse().getResponseMessage())
                                .build()
                )
                .errors(
                        error.getErrors()
                                .stream()
                                .map(object ->
                                        ErrorResponseDetail.builder()
                                                .errorCode(object.getErrorCode())
                                                .errorDetail(object.getErrorDetail())
                                                .build()

                                )
                                .collect(Collectors.toList())
                )
                .build();
    }
}
