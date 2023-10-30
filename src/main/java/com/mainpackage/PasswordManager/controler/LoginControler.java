package com.mainpackage.PasswordManager.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginControler {
    @GetMapping("/login")
    public String logToWebsite(){
        return "loginWebPage";

    }
    @PostMapping
    public String sendlogin(){
        return "/main";
    }
}
