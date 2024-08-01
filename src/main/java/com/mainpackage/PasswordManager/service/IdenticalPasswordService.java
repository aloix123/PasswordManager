package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.LoginData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IdenticalPasswordService {
    @Autowired
    private LoginDataServiceImp loginDataServiceImp;

    public List<String> ShowRepitingPasswords(){
        List<LoginData> logins=loginDataServiceImp.getAllLoginData();
        List<String> result=new ArrayList<>();
        for(int i=0;i<logins.size();i++){
            for(int j=i+1;j<logins.size();j++){
                if (logins.get(i).getPassword().equals(logins.get(j).getPassword())){
                    result.add(logins.get(i).getPassword());
                }
            }
        }
        return result;
    }

    public boolean isPasswordsRepiting(){
        return ShowRepitingPasswords().size()>0;
    }



}
