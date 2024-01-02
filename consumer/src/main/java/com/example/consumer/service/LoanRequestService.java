package com.example.consumer.service;

import com.example.consumer.dto.ReviewResponseDto;
import com.example.domain.domain.LoanReview;
import com.example.domain.repository.LoanReviewRepository;
import com.example.kafka.dto.LoanRequestDto;
import java.time.Duration;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@RequiredArgsConstructor
@Service
public class LoanRequestService {

    private final LoanReviewRepository loanReviewRepository;
    private final String nginxUrl = "http://nginx:8085/css/api/v1/request";
    private final RestTemplateBuilder restTemplateBuilder;

    public void loanRequest(LoanRequestDto loanRequestDto){
        ReviewResponseDto reviewResult = loanRequestToCb(loanRequestDto);
        saveLoanReviewData(reviewResult.toLoanReviewEntity());
    }

    private ReviewResponseDto loanRequestToCb(LoanRequestDto loanRequestDto){

        RestTemplate restTemplate = restTemplateBuilder
            .setConnectTimeout(Duration.ofMillis(1000))
            .setReadTimeout(Duration.ofMillis(1000))
            .build();
        return restTemplate.postForEntity(nginxUrl, loanRequestDto, ReviewResponseDto.class)
            .getBody();
    }

    private void saveLoanReviewData(LoanReview loanReview){
        loanReviewRepository.save(loanReview);
    }
}
