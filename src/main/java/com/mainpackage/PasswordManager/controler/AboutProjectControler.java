package com.mainpackage.PasswordManager.controler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AboutProjectControler {
    @GetMapping("/aboutProject")
    public String createAboutProject() {
        return "this is about project";
    }
}
