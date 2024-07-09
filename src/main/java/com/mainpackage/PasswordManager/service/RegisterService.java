package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {
    @Autowired
    private CustomUserRepository customUserRepository;


    public void saveUser(CustomUser customUser){
        customUserRepository.save(customUser);
    }
}
