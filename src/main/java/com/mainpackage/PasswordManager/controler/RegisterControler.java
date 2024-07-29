package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.Action.EncryptDataClass;
import com.mainpackage.PasswordManager.Util.UserUtilService;
import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.service.RegisterService;
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
    UserUtilService userUtilService=new UserUtilService();
    EncryptDataClass encryptDataClass =new EncryptDataClass();

    @PostMapping("/getStarted")
    public ResponseEntity<String> ShowRegisterInterface (@RequestBody CustomUser customUser) throws Exception {
        userUtilService.SetUserParameters(customUser);
        registerService.saveUser(customUser);
        return new ResponseEntity<>(" you created a user!!", HttpStatus.OK);
    }
}
