package com.example.consumer.dto;

import com.example.domain.domain.LoanReview;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ReviewResponseDto {
    private String userKey;
    private Double interest;
    private Long limitAmount;

    public LoanReview toLoanReviewEntity(){
        return LoanReview.builder()
            .userKey(userKey)
            .loanLimitedAmount(limitAmount)
            .loanInterest(interest)
            .build();
    }
}
