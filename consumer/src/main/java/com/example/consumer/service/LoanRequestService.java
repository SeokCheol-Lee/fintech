package com.example.consumer.service;

import com.example.domain.domain.LoanReview;
import com.example.domain.repository.LoanReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoanRequestService {

    private final LoanReviewRepository loanReviewRepository;

    public void loanRequest(){

    }

    public void loanRequestToCb(){

    }

    public void saveLoanReviewData(LoanReview loanReview){
        loanReviewRepository.save(loanReview);
    }
}
