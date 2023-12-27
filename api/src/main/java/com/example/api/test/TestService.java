package com.example.api.test;

import com.example.domain.domain.UserInfo;
import com.example.domain.repository.UserInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TestService {

    private final UserInfoRepository userInfoRepository;

    public TestDto testGetService(String userKey){
        return toDto(userInfoRepository.findByUserKey(userKey));
    }

    private TestDto toDto(UserInfo userInfo){
        return TestDto.builder()
            .userKey(userInfo.getUserKey())
            .userIncomeAmount(userInfo.getUserIncomeAmount())
            .userName(userInfo.getUserName())
            .userRegistrationNumber(userInfo.getUserRegistrationNumber())
            .build();
    }
}
