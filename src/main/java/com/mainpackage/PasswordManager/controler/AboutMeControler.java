package com.mainpackage.PasswordManager.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutMeControler {
    @GetMapping("/aboutMe")
    public String generateAboutMeWeb() {
        return "this will be web about me";
    }
}
