package com.quickbank.accounts.web.handler.error;

import com.quickbank.accounts.web.dto.response.error.ErrorResponse;
import com.quickbank.accounts.web.dto.response.error.ErrorResponseDetail;
import com.quickbank.accounts.web.util.GenericResponse;
import com.quickbank.accounts.web.util.HeaderResponse;
import com.quickbank.accounts.web.util.MessageResponse;
import lombok.NoArgsConstructor;
import org.springframework.http.ResponseEntity;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@NoArgsConstructor
public class ErrorHandler {

    public static Mono<ResponseEntity<GenericResponse>> handlerError(final Throwable error, String requestDateTime) {
        return Mono.just(ResponseEntity.status(INTERNAL_SERVER_ERROR).body(unexpectedError(error, requestDateTime)));
    }

    private static ErrorResponse unexpectedError(Throwable error, String requestDateTime) {
        return ErrorResponse
                .builder()
                .headers(
                        HeaderResponse
                                .builder()
                                .httpStatusCode(INTERNAL_SERVER_ERROR.value())
                                .httpStatusDesc(INTERNAL_SERVER_ERROR.name())
                                .requestDateTime(requestDateTime)
                                .build()
                )
                .messageResponse(
                        MessageResponse
                                .builder()
                                .responseCode(String.valueOf(INTERNAL_SERVER_ERROR.value()))
                                .responseMessage(INTERNAL_SERVER_ERROR.name())
                                .responseDetails(error.getMessage())
                                .build()
                )
                .errors(
                        getNullError(INTERNAL_SERVER_ERROR.name(), "Unknown Error")
                )
                .build();
    }

    private static List<ErrorResponseDetail> getNullError(String code, String detail) {
        List<ErrorResponseDetail> responseErrorsList = new ArrayList<ErrorResponseDetail>();
        responseErrorsList.add(ErrorResponseDetail
                .builder()
                .errorCode(code)
                .errorDetail(detail)
                .build());
        return responseErrorsList;
    }
}
