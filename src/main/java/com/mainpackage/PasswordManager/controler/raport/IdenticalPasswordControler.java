package com.mainpackage.PasswordManager.controler.raport;

import com.mainpackage.PasswordManager.service.IdenticalPasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController()
@RequestMapping("raport")
public class IdenticalPasswordControler {
    @Autowired
    private IdenticalPasswordService identicalPasswordService;
    @GetMapping("/IdenticalPassword")
    public ResponseEntity<List<String>> showRaport(){

        if(identicalPasswordService.isPasswordsRepiting()){
            List<String> bunchOfRepitingPasswords=identicalPasswordService.ShowRepitingPasswords();
            return new ResponseEntity<>(bunchOfRepitingPasswords, HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(Arrays.asList(),HttpStatus.OK);
        }
    }
}
