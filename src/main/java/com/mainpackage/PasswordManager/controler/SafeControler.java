package com.mainpackage.PasswordManager.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SafeControler {
    @GetMapping("/app/safes")
    public String showSafes(){
        return "safes";
    }
}
