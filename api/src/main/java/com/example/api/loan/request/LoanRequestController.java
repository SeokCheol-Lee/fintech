package com.example.api.loan.request;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/fintech/api/v1")
public class LoanRequestController {

    private final LoanRequestServiceImpl loanRequestService;

    @PostMapping("/request")
    public ResponseEntity<LoanRequestDto.LoanRequestResponseDto> loanRequest(
        @RequestBody LoanRequestDto.LoanRequestInputDto loanRequestInputDto)
        throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException,
        IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        return ResponseEntity.ok(loanRequestService.loanRequestMain(loanRequestInputDto));
    }
}
