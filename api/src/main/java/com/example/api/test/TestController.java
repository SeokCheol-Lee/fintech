package com.example.api.test;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/api/v1")
public class TestController {

    private final TestService testService;

    @GetMapping("/test/get/{userKey}")
    public TestDto Test(@PathVariable String userKey){
        return testService.testGetService(userKey);
    }
}
