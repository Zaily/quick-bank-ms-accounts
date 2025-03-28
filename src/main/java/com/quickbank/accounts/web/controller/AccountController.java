package com.quickbank.accounts.web.controller;

import com.quickbank.accounts.web.dto.request.CreateAccountRequest;
import com.quickbank.accounts.web.util.GenericResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@CrossOrigin(origins = "*")
@RequiredArgsConstructor
@RestController
@Validated
public class AccountController {

    @PostMapping("/accounts")
    public Mono<ResponseEntity<GenericResponse>> createAccount(
            CreateAccountRequest request
    ){
        return null;
    }

}
