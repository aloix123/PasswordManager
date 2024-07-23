package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.Util.UserUtilService;
import com.mainpackage.PasswordManager.model.Safe;
import com.mainpackage.PasswordManager.repository.SafeRepository;
import com.mainpackage.PasswordManager.service.SafeServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class SafeControler {
    @Autowired
    private SafeServiceImp safeServiceImp;

    @GetMapping("safes")
    public ResponseEntity<List<Optional<Safe>>> getSafes(){
        return new  ResponseEntity<List<Optional<Safe>>>(safeServiceImp.getSafesByUserId(UserUtil.getId()),HttpStatus.OK);
    }
    @PostMapping("safes/add")
    public ResponseEntity<String> createSafe(@RequestBody Safe safe){
        if(UserUtilService.isUserLogedIn()){
            safe.setUserid(UserUtil.getId());
            safeServiceImp.createSafe(safe);
            return  new ResponseEntity<>("you created new safe", HttpStatus.CREATED);
        }
        else{
            return  new ResponseEntity<>("you need to log in first!!", HttpStatus.NOT_FOUND);
        }

    }
    @DeleteMapping("safes/delete/{id}")
    public void deleteSafe(@PathVariable("id") Long id){
        safeServiceImp.deleteById(id);
    }
}
