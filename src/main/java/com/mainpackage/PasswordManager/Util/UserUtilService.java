package com.mainpackage.PasswordManager.Util;

import com.mainpackage.PasswordManager.model.CustomUser;



public class UserUtilService {
    public void SetUserParameters(CustomUser customUser){
        UserUtil.setId(customUser.getUserid());
        UserUtil.setLogin(customUser.getLogin());
        UserUtil.setEmail(customUser.getEmail());
        UserUtil.setImage(customUser.getImage());
        UserUtil.setMainPassword(customUser.getMainPassword());

    }
    public static  boolean isUserLogedIn(){
        return UserUtil.getId().describeConstable().isEmpty();
    }
}
