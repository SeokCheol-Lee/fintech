package com.example.css.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

public class LoanResultDto {

    @AllArgsConstructor
    @Getter
    public static class ResponseDto{
        private String userKey;
        private Double interest;
        private Long limitAmount;

    }
}
