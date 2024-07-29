package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.repository.CustomUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserServiceImp {
    @Autowired
    private CustomUserRepository customUserRepository;

    public Long getLogdUserIdByLoginAndPassword(String login,String password){
        Optional<CustomUser> customUser = customUserRepository.findByLoginAndPassword(login,password);
        System.out.println(customUser.toString());
        return customUser.get().getUserid();
    }

    public void deleteById(Long id){
        customUserRepository.deleteById(id);
    }
}
