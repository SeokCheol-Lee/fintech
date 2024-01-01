package com.example.css.service;

import com.example.css.dto.LoanRequestDto;
import com.example.css.dto.LoanResultDto;
import com.example.css.dto.LoanResultDto.ResponseDto;
import org.springframework.stereotype.Service;

@Service
public class LoanReviewService {
    public LoanResultDto.ResponseDto loanReview(LoanRequestDto.RequestInputDto loanRequestDto){
        if(loanRequestDto.getUserIncomeAmount() < 0)
            throw new RuntimeException("Invalid userIncomeAmount Param");
        if(loanRequestDto.getUserIncomeAmount() < 10000000)
            return new ResponseDto(loanRequestDto.getUserKey(), 0.0, 10000000L);
        if(loanRequestDto.getUserIncomeAmount() < 20000000)
            return new ResponseDto(loanRequestDto.getUserKey(), 10.0, 20000000L);
        if(loanRequestDto.getUserIncomeAmount() < 30000000)
            return new ResponseDto(loanRequestDto.getUserKey(), 9.0, 30000000L);
        if(loanRequestDto.getUserIncomeAmount() < 40000000)
            return new ResponseDto(loanRequestDto.getUserKey(), 8.0, 40000000L);
        if(loanRequestDto.getUserIncomeAmount() < 50000000)
            return new ResponseDto(loanRequestDto.getUserKey(), 7.0, 50000000L);
        if(loanRequestDto.getUserIncomeAmount() >= 50000000)
            return new ResponseDto(loanRequestDto.getUserKey(), 6.0, 60000000L);
        throw new RuntimeException("Invalid userIncomeAmount Param");
    }
}
