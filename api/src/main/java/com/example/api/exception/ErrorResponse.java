package com.example.api.exception;

import java.time.LocalDateTime;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@Builder
@AllArgsConstructor
@RequiredArgsConstructor(access = AccessLevel.PRIVATE)
public class ErrorResponse {

    private String errorCode;
    private String errorMessage;
    private LocalDateTime timeStamp;

    public static ErrorResponse of(CustomException exception) {

        return ErrorResponse.builder()
            .errorCode(exception.getErrorCode().getErrorCode())
            .errorMessage(exception.getErrorCode().getErrorMessage())
            .timeStamp(LocalDateTime.now())
            .build();
    }
}
