package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.repository.CustomUserRepository;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.SqlQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginServiceImp implements LoginService{
    @Autowired
    private  CustomUserRepository customUserRepository;

    public Optional<CustomUser> findCustomUserByLoginAndPassword(CustomUser customUser) {
        return customUserRepository.findByLoginAndPassword(customUser.getLogin(), customUser.getMainPassword());

    }
    @Override
    public boolean IsUserInDataBase(CustomUser customUser) {
        Optional<CustomUser> user = findCustomUserByLoginAndPassword(customUser);
        return user.isPresent();
    }
}
