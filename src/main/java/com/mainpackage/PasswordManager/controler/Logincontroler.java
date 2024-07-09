package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.Util.UserUtilService;
import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.service.LoginService;
import com.mainpackage.PasswordManager.service.LoginServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logincontroler {
    @Autowired
    LoginServiceImp loginServiceImp;
    UserUtilService userUtilService=new UserUtilService();
    @PostMapping("/LogIn")
    public ResponseEntity<String> ShowRegisterInterface (@RequestBody CustomUser customUser){

        userUtilService.SetUserParameters(customUser);
        if(loginServiceImp.IsUserInDataBase(customUser)){
            return new ResponseEntity<>(" you loged in!!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(" there is no user with those parameters", HttpStatus.NOT_FOUND);
        }
    }

}
