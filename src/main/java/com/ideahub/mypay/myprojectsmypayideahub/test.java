package com.ideahub.mypay.myprojectsmypayideahub;

import com.ideahub.mypay.myprojectsmypayideahub.security.AESUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

public class test {

    public static void main(String[] args) throws NoSuchAlgorithmException, InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {

        String input = "newPass1232";
        SecretKey key = AESUtil.generateKey(128);
        IvParameterSpec ivParameterSpec = AESUtil.generateIv();
        String algorithm = "AES/CBC/PKCS5Padding";
        String cipherText = AESUtil.encrypt(algorithm, input, key, ivParameterSpec);
        String plainText = AESUtil.decrypt(algorithm, cipherText, key, ivParameterSpec);


        System.out.println(cipherText);
        System.out.println(plainText);
    }
}
