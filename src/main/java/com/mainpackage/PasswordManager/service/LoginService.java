package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.CustomUser;

public interface LoginService {
    public boolean IsUserInDataBase(CustomUser customUser);
}
