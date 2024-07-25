package com.mainpackage.PasswordManager;

import com.mainpackage.PasswordManager.dataCryptingpackage.AESCryptor;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DataEncryptingTestClass {


    @Test
    public void AESCrypto_CheckIfEncryptionAndDecryptionIsCorrect() throws Exception {

        String somePassword = "somePassword";
        String encryptPassowrd=AESCryptor.encrypt(somePassword);
        String decryptedPassword=AESCryptor.decrypt(encryptPassowrd);
        Assertions.assertEquals(somePassword,decryptedPassword);
    }
}
