package com.example.api.loan.encrypt;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.springframework.stereotype.Component;

@Component
public class EncryptComponent {

    private final String secretKey = "1234567891234567";

    private Encoder encoder = Base64.getEncoder();
    private Decoder decoder = Base64.getDecoder();

    public String encryptString(String encryptString)
        throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException
        , NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] bytes = cipherPkcs5(Cipher.ENCRYPT_MODE, secretKey).doFinal(
            encryptString.getBytes(StandardCharsets.UTF_8));
        return new String(encoder.encode(bytes));
    }

    public String decryptString(String decryptString)
        throws InvalidAlgorithmParameterException, NoSuchPaddingException, UnsupportedEncodingException
        , NoSuchAlgorithmException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
        byte[] decode = decoder.decode(decryptString.getBytes(StandardCharsets.UTF_8));
        return new String(cipherPkcs5(Cipher.DECRYPT_MODE,secretKey).doFinal(decode));
    }

    private Cipher cipherPkcs5(Integer opMode, String secretKey)
        throws NoSuchPaddingException, NoSuchAlgorithmException, UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeyException {
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(secretKey.getBytes("UTF-8"), "AES");
        IvParameterSpec ivParameterSpec = new IvParameterSpec(
            secretKey.substring(0, 16).getBytes(StandardCharsets.UTF_8));
        cipher.init(opMode,keySpec,ivParameterSpec);
        return cipher;
    }
}
