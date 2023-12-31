package com.example.kafka.dto;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoanRequestDto {
    private String userKey;
    private String userName;
    private String userRegistrationNumber;
    private Long userIncomeAmount;
}
