package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.model.SecureNote;
import com.mainpackage.PasswordManager.service.SecureNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("safes/{safeid}/folders/{folderid}/SecureNote")
public class SecureNoteControler {
    @Autowired
    private SecureNoteService secureNoteService;
    @GetMapping("/")
    public ResponseEntity<List<Optional<SecureNote>>> genSecureNotes(@PathVariable("folderid") Long folderid){
        return new ResponseEntity<>(secureNoteService.getSecureNotesByFolderId(folderid), HttpStatus.OK);
    }
    @PostMapping("/add")
    public ResponseEntity<String> addSecureNote(@RequestBody SecureNote secureNote,@PathVariable("folderid") Long folderid){
        secureNoteService.createSEcureNoteForFolder(secureNote,folderid);
        return new ResponseEntity<>("you added a secure note",HttpStatus.CREATED);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteSecureNote(@PathVariable("id") Long id){
        secureNoteService.deleteSecureNoteById(id);
        return new ResponseEntity<>("you deleted a secure note",HttpStatus.OK);
    }

}
