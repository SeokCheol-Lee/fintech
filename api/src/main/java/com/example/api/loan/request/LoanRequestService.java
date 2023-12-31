package com.example.api.loan.request;

import com.example.api.loan.request.LoanRequestDto.LoanRequestInputDto;
import com.example.domain.domain.UserInfo;
import com.fasterxml.jackson.core.JsonProcessingException;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

public interface LoanRequestService {

    LoanRequestDto.LoanRequestResponseDto loanRequestMain(LoanRequestInputDto loanRequestInputDto)
        throws InvalidAlgorithmParameterException, NoSuchPaddingException
        , UnsupportedEncodingException, IllegalBlockSizeException, NoSuchAlgorithmException
        , BadPaddingException, InvalidKeyException, JsonProcessingException;

    UserInfo saveUserInfo(UserInfoDto userInfoDto);

    void loanRequestReview(UserInfoDto userInfoDto) throws JsonProcessingException;


}
