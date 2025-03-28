package com.quickbank.accounts.application.usecase.createAccount.mapper;

import com.quickbank.accounts.application.error.ErrorResponseInfoDetail;
import com.quickbank.accounts.application.error.UseCaseErrorResponse;
import com.quickbank.accounts.application.payload.CreateAccountInformation;
import com.quickbank.accounts.application.payload.CreateAccountInformationPayload;
import com.quickbank.accounts.application.payload.CreateAccountPayload;
import com.quickbank.accounts.application.payload.dto.CreateAccountDto;
import com.quickbank.accounts.application.util.GenericResponseCodes;
import com.quickbank.accounts.application.util.HeaderObjectInfoResponse;
import com.quickbank.accounts.application.util.MessageObjectInfoResponse;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;

import java.security.PublicKey;
import java.util.UUID;

@UtilityClass
public class CreateAccountUseCaseMapper {

    public static CreateAccountInformation buildSuccessResponse(
            HttpStatus httpStatus,
            String requestDatetime,
            GenericResponseCodes genericResponseCodes,
            String responseDetails,
            CreateAccountDto accountDto
    ){
        return new CreateAccountInformation(
                HeaderObjectInfoResponse.builder()
                        .httpStatusCode(httpStatus.value())
                        .httpStatusDesc(httpStatus.name())
                        .requestDateTime(requestDatetime)
                        .build(),
                MessageObjectInfoResponse.builder()
                        .responseCode(genericResponseCodes.getValue())
                        .responseMessage(genericResponseCodes.getDescription())
                        .responseDetails(responseDetails)
                        .build(),
                CreateAccountInformationPayload.builder()
                        .account(
                                CreateAccountPayload.builder()
                                        .accountId(accountDto.getAccountId())
                                        .accountType(accountDto.getAccountType())
                                        .ownerId(accountDto.getOwnerId())
                                        .currency(accountDto.getAccountId())
                                        .status(accountDto.getStatus())
                                        .createdDateTime(accountDto.getCreatedDateTime())
                                        .build()
                        )
                        .build()
        );
    }

    public static UseCaseErrorResponse buildErrorResponse(String requestDateTime, HttpStatus status, GenericResponseCodes genericResponseCodes, String errorMessage) {

        return new UseCaseErrorResponse(
                HeaderObjectInfoResponse.builder()
                        .httpStatusCode(status.value())
                        .httpStatusDesc(status.name())
                        .requestDateTime(requestDateTime)
                        .build(),
                MessageObjectInfoResponse.builder()
                        .responseCode(genericResponseCodes.getValue())
                        .responseMessage(genericResponseCodes.getDescription())
                        .responseDetails(genericResponseCodes.getDescription())
                        .build(),
                ErrorResponseInfoDetail.builder()
                        .errorCode(String.valueOf(status.value()))
                        .errorDetail(errorMessage)
                        .build()
        );
    }

    public static CreateAccountDto commandtoCreateAccountDto(
            String ownerId,
            String accountType,
            String currency,
            String status,
            String createdDateTime
    ){
        return CreateAccountDto.builder()
                .accountId(UUID.randomUUID().toString())
                .accountType(accountType)
                .ownerId(ownerId)
                .currency(currency)
                .status(status)
                .createdDateTime(createdDateTime)
                .build();
    }
}
