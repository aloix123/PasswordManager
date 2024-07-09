package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.Util.UserUtilService;
import com.mainpackage.PasswordManager.model.CustomUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logincontroler {
    UserUtilService userUtilService=new UserUtilService();
    @PostMapping("/LogIn")
    public ResponseEntity<String> ShowRegisterInterface (@RequestBody CustomUser customUser){
        userUtilService.SetUserParameters(customUser);
        return new ResponseEntity<>(" you loged in!!", HttpStatus.OK);
    }

}
