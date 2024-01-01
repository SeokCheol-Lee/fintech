package com.example.api.loan.review;

import com.example.api.exception.CustomException;
import com.example.api.exception.ErrorCode;
import com.example.api.loan.review.LoanReviewDto.LoanResult;
import com.example.api.loan.review.LoanReviewDto.LoanReviewResponseDto;
import com.example.domain.domain.LoanReview;
import com.example.domain.repository.LoanReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoanReviewServiceImpl implements LoanReviewService{

    private final LoanReviewRepository loanReviewRepository;

    @Override
    public LoanReviewResponseDto loanReviewMain(String userKey) {
        LoanReviewDto.LoanReview loanReview = getLoanResult(userKey);
        LoanResult loanResult = LoanResult.builder()
            .userLimitAmount(loanReview.getLoanLimitedAmount())
            .userLoanInterest(loanReview.getLoanInterest()).build();

        return LoanReviewDto.LoanReviewResponseDto.builder()
            .userKey(userKey)
            .loanResult(loanResult)
            .build();
    }

    @Cacheable(value = {"REVIEW"}, key = "#userKey", cacheManager = "redisCacheManager")
    @Override
    public LoanReviewDto.LoanReview getLoanResult(String userKey) {
        LoanReview loanReview = loanReviewRepository.findByUserKey(userKey)
            .orElseThrow(() -> new CustomException(ErrorCode.RESULT_NOT_FOUND));

        return LoanReviewDto.LoanReview.builder()
            .userKey(loanReview.getUserKey())
            .loanLimitedAmount(loanReview.getLoanLimitedAmount())
            .loanInterest(loanReview.getLoanInterest())
            .build();
    }
}
