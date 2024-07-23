package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.repository.CustomUserRepository;

import org.hibernate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UpdateServiceImp {

    @Autowired
    private CustomUserRepository customUserRepository;

    public void updateUser(CustomUser user) {
        CustomUser customUser=customUserRepository.findById(UserUtil.getId()).get();
        customUser.setEmail(user.getEmail());
        customUser.setImage(user.getImage());
        customUser.setLogin(user.getLogin());
        customUser.setMainPassword(user.getMainPassword());
        customUserRepository.save(customUser);


    }
}
