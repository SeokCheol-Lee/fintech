package com.example.api.exception;

import java.util.HashMap;
import java.util.Map;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    RESULT_NOT_FOUND(HttpStatus.BAD_REQUEST, "E001", "result not found");

    private final HttpStatus statusCode;
    private final String errorCode;
    private final String errorMessage;

    private static final Map<String, ErrorCode> ERROR_CODE_MAP = new HashMap<>();

    static {
        for (ErrorCode errorCode : ErrorCode.values()) {
            ERROR_CODE_MAP.put(errorCode.errorMessage, errorCode);
        }
    }

    public static ErrorCode findCode(String description) {
        return ERROR_CODE_MAP.get(description);
    }
}
