package com.quickbank.accounts.web.dto.response.error;

import com.quickbank.accounts.web.util.GenericResponse;
import com.quickbank.accounts.web.util.HeaderResponse;
import com.quickbank.accounts.web.util.MessageResponse;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResponse implements GenericResponse, Serializable {

    private HeaderResponse headers;
    private MessageResponse messageResponse;
    private List<ErrorResponseDetail> errors;
}
