package com.example.api.loan.request;

import com.example.api.loan.GenerateKey;
import com.example.api.loan.encrypt.EncryptComponent;
import com.example.api.loan.request.LoanRequestDto.LoanRequestInputDto;
import com.example.api.loan.request.LoanRequestDto.LoanRequestResponseDto;
import com.example.domain.domain.UserInfo;
import com.example.domain.repository.UserInfoRepository;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class LoanRequestServiceImpl implements LoanRequestService{

    private final UserInfoRepository userInfoRepository;
    private final GenerateKey generateKey;
    private final EncryptComponent encryptComponent;

    @Override
    public LoanRequestResponseDto loanRequestMain(LoanRequestInputDto loanRequestInputDto)
        throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException
        , IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String userKey = generateKey.generateUserKey();
        loanRequestInputDto.setUserRegistrationNumber(encryptComponent.encryptString(loanRequestInputDto.getUserRegistrationNumber()));
        saveUserInfo(loanRequestInputDto.toUserInfoDto(userKey));
        loanRequestReview("");
        return new LoanRequestResponseDto(userKey);
    }

    @Override
    public UserInfo saveUserInfo(UserInfoDto userInfoDto) {
        return userInfoRepository.save(userInfoDto.toEntity());
    }

    @Override
    public void loanRequestReview(String userKey) {

    }
}
