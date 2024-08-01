package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.Action.CreateDefaultFolderAndSafeClass;
import com.mainpackage.PasswordManager.Action.EncryptDataClass;
import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.Util.UserUtilService;
import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.model.Folder;
import com.mainpackage.PasswordManager.model.Safe;
import com.mainpackage.PasswordManager.repository.CustomUserRepository;
import com.mainpackage.PasswordManager.service.CustomUserServiceImp;
import com.mainpackage.PasswordManager.service.FolderService;
import com.mainpackage.PasswordManager.service.RegisterService;
import com.mainpackage.PasswordManager.service.SafeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RegisterControler {
    @Autowired
    private RegisterService registerService;
    @Autowired
    private CustomUserServiceImp customUserServiceImp;
    @Autowired
    private CustomUserRepository customUserRepository;
    @Autowired
    private CreateDefaultFolderAndSafeClass createDefaultFolderAndSafeClass;
    UserUtilService userUtilService=new UserUtilService();
    EncryptDataClass encryptDataClass =new EncryptDataClass();

    @PostMapping("/getStarted")
    public ResponseEntity<String> ShowRegisterInterface (@RequestBody CustomUser customUser) throws Exception {
        if(customUser.isSomeDataNull()){
            return new ResponseEntity<>("make sure you fiil all data",HttpStatus.BAD_REQUEST);
        }
        if(customUserServiceImp.isLoginrepeting(customUser.getLogin())){
            return new ResponseEntity<>("there is  an account with the same login",HttpStatus.BAD_REQUEST);
        }
        if(customUserServiceImp.isEmailRepetind(customUser.getEmail())){
            return new ResponseEntity<>("there is  an account with the same email",HttpStatus.BAD_REQUEST);
        }
        else{
            createDefaultFolderAndSafeClass.execute(customUser);
            return new ResponseEntity<>(" you created a user!!", HttpStatus.OK);
        }
    }



}
