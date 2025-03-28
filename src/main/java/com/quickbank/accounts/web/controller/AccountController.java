package com.quickbank.accounts.web.controller;

import com.quickbank.accounts.web.dto.request.CreateAccountRequest;
import com.quickbank.accounts.web.handler.createAccount.CreateAccountHandler;
import com.quickbank.accounts.web.util.GenericResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import static org.springframework.http.MediaType.*;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@Validated
@Slf4j
public class AccountController {

    private final CreateAccountHandler handler;

    @PostMapping(value = "/accounts", consumes = "application/json")
    public Mono<ResponseEntity<GenericResponse>> createAccount(
            @RequestBody CreateAccountRequest request
    ){
        log.info("/accounts, body: [{}]", request);
        return handler.execute(request.getOwnerId(), request.getAccountType(), request.getCurrency());
    }

}
