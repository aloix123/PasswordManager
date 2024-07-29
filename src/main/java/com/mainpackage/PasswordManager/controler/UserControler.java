package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.repository.SecureNoteRepository;
import com.mainpackage.PasswordManager.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserControler {
    @Autowired
    private SecureNoteRepository secureNoteRepository;
    @Autowired
    private LoginDataServiceImp loginDataServiceImp;
    @Autowired
    private CardServiceImp cardServiceImp;
    @Autowired
    private FolderService folderService;
    @Autowired
    private SafeServiceImp safeServiceImp;
    @Autowired
    private CustomUserServiceImp customUserServiceImp;
    @DeleteMapping("user/delete/")
    public ResponseEntity<String> deleteUser() {
        deleteAllUserDataByUserId(UserUtil.getId());
        return new ResponseEntity<>("you deleted a user ", HttpStatus.OK);
    }

    public void  deleteAllUserDataByUserId(Long id){
        secureNoteRepository.deleteByCustomUserId(id);
        loginDataServiceImp.deleteLoginDataByUserID(id);
        cardServiceImp.deleteCardsByUserId(id);
        folderService.deleteFolderById(id);
        safeServiceImp.deleteAllByUserId(id);
        customUserServiceImp.deleteById(id);
    }


}
