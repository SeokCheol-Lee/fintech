package com.example.kafka.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
@AllArgsConstructor
public class LoanRequestDto {
    private String userKey;
    private String userName;
    private Long userIncomeAmount;
    private String userRegistrationNumber;

}
