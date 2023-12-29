package com.example.api.loan.review;

import com.example.api.exception.CustomException;
import com.example.api.exception.ErrorResponse;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice(basePackageClasses = LoanReviewController.class)
public class LoanReviewControllerAdvice {

    @ExceptionHandler(CustomException.class)
    public ErrorResponse customExceptionHandler(CustomException customException){
        return ErrorResponse.of(customException);
    }
}
