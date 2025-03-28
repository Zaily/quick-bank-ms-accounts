package com.quickbank.accounts.web.handler;

import com.quickbank.accounts.web.dto.response.error.ErrorResponse;
import com.quickbank.accounts.web.util.GenericResponse;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

@NoArgsConstructor
@Slf4j
public class ResponseBuilder {

    public ResponseEntity<GenericResponse> mapResponseBuilder(GenericResponse T, HttpStatus status) {
        if (T instanceof ErrorResponse) {
            ErrorResponse response = Optional.of((ErrorResponse) T).get();
            return new ResponseEntity<>(response, HttpStatus.valueOf(response.getHeaders().getHttpStatusCode()));
        } else {
            return new ResponseEntity<>(T, status);
        }
    }
}
