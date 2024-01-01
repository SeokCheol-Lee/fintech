package com.example.css.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class LoanRequestDto {
    @Getter
    @AllArgsConstructor
    public static class RequestInputDto{
        private String userKey;
        private String userName;
        private Long userIncomeAmount;
        private String userRegistrationNumber;
    }
}
