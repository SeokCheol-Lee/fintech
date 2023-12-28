package com.example.api.loan.review;

import com.example.domain.domain.LoanReview;

public interface LoanReviewService {

    LoanReviewDto.LoanReviewResponseDto loanReviewMain(String userKey);

    LoanReviewDto.LoanReview getLoanResult(String userKey);
}
