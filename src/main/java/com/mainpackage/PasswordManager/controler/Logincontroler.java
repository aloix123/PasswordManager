package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.Util.UserUtilService;
import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.service.CustomUserServiceImp;
import com.mainpackage.PasswordManager.service.LoginServiceImp;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Logincontroler {
    @Autowired
    LoginServiceImp loginServiceImp;
    @Autowired
    CustomUserServiceImp customUserServiceImp;
    UserUtilService userUtilService=new UserUtilService();
    Logger logger = LoggerFactory.getLogger(Logincontroler.class);

    @PostMapping("/login")
    public ResponseEntity<String> ShowRegisterInterface (@RequestBody CustomUser customUser){
        customUser.setUserid(customUserServiceImp.getLogdUserIdByLoginAndPassword(customUser.getLogin(), customUser.getMainPassword()));
        userUtilService.SetUserParameters(customUser);
        logger.info(UserUtil.getLogin());
        if(loginServiceImp.IsUserInDataBase(customUser)){
            return new ResponseEntity<>(" you loged in!!", HttpStatus.OK);
        }
        else {
            return new ResponseEntity<>(" there is no user with those parameters", HttpStatus.NOT_FOUND);
        }
    }

}
