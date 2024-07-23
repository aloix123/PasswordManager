package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.model.LoginData;
import com.mainpackage.PasswordManager.repository.LoginDataRepository;
import com.mainpackage.PasswordManager.service.LoginDataServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("safes/{safeid}/folders/{folderid}/Logindata")
public class LoginDataControler {
    @Autowired
    private LoginDataServiceImp loginDataServiceImp;

    @GetMapping("/")
    public ResponseEntity<List<Optional<LoginData>>> getLoginData( @PathVariable("folderid") Long folderid) {
        return new ResponseEntity<>(loginDataServiceImp.getLoginDataForFolder(folderid), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<String> addLoginData(@RequestBody LoginData loginData,@PathVariable("folderid") Long folderid) {
        LoginData newLoginData = new LoginData();
        newLoginData.setFolderid(folderid);
        newLoginData.setPassword(loginData.getPassword());
        newLoginData.setDescryption(loginData.getDescryption());
        newLoginData.setURL(loginData.getURL());
        newLoginData.setUserName(loginData.getUserName());
        newLoginData.setName(loginData.getName());

        loginDataServiceImp.createLoginDataForFolder(newLoginData);
        return new ResponseEntity<>("you added new login to folder",HttpStatus.OK);
    }
    @DeleteMapping("/delete/{deleteid}")
    public ResponseEntity<String> deleteLoginData(@PathVariable("deleteid") Long deleteid) {
        loginDataServiceImp.DeleteLoginDataForFolderById(deleteid);
        return new ResponseEntity<>("you deleted",HttpStatus.OK);
    }
}
