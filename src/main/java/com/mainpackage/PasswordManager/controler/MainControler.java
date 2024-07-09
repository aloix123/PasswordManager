package com.mainpackage.PasswordManager.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainControler {

    @GetMapping("/")
    public String createIndex() {
        return "Hello Web";
    }
}
