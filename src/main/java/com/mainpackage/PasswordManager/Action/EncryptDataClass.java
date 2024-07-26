package com.mainpackage.PasswordManager.Action;

import com.mainpackage.PasswordManager.dataCryptingpackage.AESCryptor;
import com.mainpackage.PasswordManager.model.Card;
import com.mainpackage.PasswordManager.model.CustomUser;
import org.mindrot.jbcrypt.BCrypt;

public class EncryptDataClass {

    public CustomUser getHashedUser(CustomUser customUser) throws Exception {
        System.out.println(AESCryptor.encrypt(customUser.getLogin()));
        System.out.println(AESCryptor.decrypt(customUser.getLogin()));
        return customUser;
    }



}
