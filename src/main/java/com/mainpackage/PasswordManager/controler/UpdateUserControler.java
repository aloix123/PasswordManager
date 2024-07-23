package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.model.CustomUser;
import com.mainpackage.PasswordManager.service.UpdateServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateUserControler {
    @Autowired
    UpdateServiceImp updateServiceImp;

    @PostMapping("update")
    public String updateUser(@RequestBody CustomUser user) {
        updateServiceImp.updateUser(user);
        return "success";
    }

}
