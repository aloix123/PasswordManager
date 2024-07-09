package com.mainpackage.PasswordManager.Util;

import com.mainpackage.PasswordManager.model.CustomUser;



public class UserUtilService {
    public void SetUserParameters(CustomUser customUser){
        UserUtil.setLogin(customUser.getLogin());
        UserUtil.setEmail(customUser.getEmail());
        UserUtil.setImage(customUser.getImage());
        UserUtil.setMainPassword(customUser.getMainPassword());

    }
}
