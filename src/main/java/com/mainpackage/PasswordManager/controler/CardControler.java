package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.model.Card;
import com.mainpackage.PasswordManager.service.CardServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController()
@RequestMapping("safes/{safeid}/folders/{folderid}/cards")
public class CardControler {
    @Autowired
    private CardServiceImp cardServiceImp;

    @GetMapping("/")
    public ResponseEntity<List<Optional<Card>>> getCards(@PathVariable("folderid") Long folderid){
        return new ResponseEntity<>(cardServiceImp.getAllCards(folderid), HttpStatus.OK);
    }

    @PostMapping("add")
    public ResponseEntity<String> addCard(@PathVariable("folderid") Long folderid, @RequestBody Card card){
        cardServiceImp.addTofolder(card, folderid);
        return new ResponseEntity<>("Successfully added card", HttpStatus.OK);
    }
    @DeleteMapping("delete/{id}")
    public ResponseEntity<String> deleteCard(@PathVariable("id") Long id){
        cardServiceImp.removeCard(id);
        return new ResponseEntity<>("Successfully deleted card", HttpStatus.OK);
    }
}
