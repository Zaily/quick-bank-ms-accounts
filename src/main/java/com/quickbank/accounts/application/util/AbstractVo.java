package com.quickbank.accounts.application.util;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Optional;

@Getter
@NoArgsConstructor
public class AbstractVo<T> implements Serializable {
    private boolean success;
    private String responseMessage;
    private Optional<T> payload;

    public AbstractVo(final Optional<T> payload, final String responseMessage) {
        this.payload = payload;
        this.responseMessage = responseMessage;
    }

    public boolean isSuccess() {
        success = payload.isPresent();
        return success;
    }

}