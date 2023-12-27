package com.example.api.loan.request;

import lombok.Getter;
import lombok.Setter;

public class LoanRequestDto {

    @Setter
    @Getter
    public static class LoanRequestInputDto{
        private String userName;
        private Long userIncomeAmount;
        private String userRegistrationNumber;

        UserInfoDto toUserInfoDto(String userKey){
            return UserInfoDto.builder()
                .userKey(userKey)
                .userName(userName)
                .userIncomeAmount(userIncomeAmount)
                .userRegistrationNumber(userRegistrationNumber)
                .build();
        }
    }

    @Getter
    public static class LoanRequestResponseDto{
        private String userKey;

        public LoanRequestResponseDto(String userKey){
            this.userKey = userKey;
        }
    }
}
