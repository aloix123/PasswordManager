package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.Folder;
import com.mainpackage.PasswordManager.model.LoginData;
import com.mainpackage.PasswordManager.repository.LoginDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LoginDataServiceImp {
    @Autowired
    private LoginDataRepository loginDataRepository;

    public void createLoginDataForFolder(LoginData loginData){
        loginDataRepository.save(loginData);
    }
    public List<Optional<LoginData>> getLoginDataForFolder(Long folderId){
        return loginDataRepository.getLoginDataByfolderId(folderId);
    }
    public void DeleteLoginDataForFolderById(Long loginDataId){
        loginDataRepository.deleteById(loginDataId);
    }
}
