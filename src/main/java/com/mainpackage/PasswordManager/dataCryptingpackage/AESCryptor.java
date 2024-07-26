package com.mainpackage.PasswordManager.dataCryptingpackage;

import javax.crypto.Cipher;

import java.util.Base64;

public class AESCryptor {

    public static String encrypt(String plaintext) throws Exception {
        Base64.Encoder encoder = Base64.getEncoder();
        String encodedString = encoder.encodeToString(plaintext.getBytes());
        return encodedString;
    }

    public static String decrypt(String ciphertext ) throws Exception {
        Base64.Decoder decoder = Base64.getDecoder();
        byte[] bytes = decoder.decode(ciphertext);
        String result=new String(bytes);
        return result;
    }



}
