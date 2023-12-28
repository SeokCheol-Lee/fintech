package com.example.api.loan.review;

import lombok.Builder;
import lombok.Getter;

public class LoanReviewDto {

    @Builder
    @Getter
    static class LoanReviewResponseDto{
        private String userKey;
        private LoanResult loanResult;
    }

    @Builder
    static class LoanResult{
        private Long userLimitAmount;
        private Double userLoanInterest;
    }

    @Builder
    @Getter
    static class LoanReview{
        private String userKey;

        private Long loanLimitedAmount;

        private Double loanInterest;
    }
}
