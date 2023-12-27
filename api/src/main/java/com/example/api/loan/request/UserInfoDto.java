package com.example.api.loan.request;

import com.example.domain.domain.UserInfo;
import lombok.Builder;

@Builder
public class UserInfoDto {
    private String userKey;
    private String userName;
    private String userRegistrationNumber;
    private Long userIncomeAmount;

    UserInfo toEntity(){
        return UserInfo.builder()
            .userName(userName)
            .userKey(userKey)
            .userRegistrationNumber(userRegistrationNumber)
            .userIncomeAmount(userIncomeAmount)
            .build();
    }
}
