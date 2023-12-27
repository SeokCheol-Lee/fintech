package com.example.api.test;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class TestDto {
    private String userKey;
    private String userRegistrationNumber;
    private String userName;
    private Long userIncomeAmount;
}
