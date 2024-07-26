package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.Card;
import com.mainpackage.PasswordManager.repository.CardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CardServiceImp {
    @Autowired
    private CardRepository cardRepository;

    public List<Optional<Card>> getAllCards(Long folderid) {
        return cardRepository.getCardsByFolderid(folderid);
    }

    public void addTofolder(Card card, Long folderid) {
        card.setFolderid(folderid);
        cardRepository.save(card);
    }
    public void removeCard(Long cardid){
        cardRepository.deleteById(cardid);
    }

    public String getSafeNameByfolderId(Long folderid) {
        return cardRepository.getSafeNameByFolderid(folderid);
    }

    public List<Optional<Card>> getAllCardsByuserId(Long userid) {
        return cardRepository.getAllCardsBycustomUserId(userid);
    }

    public String getFolderName(Long folderid) {
        return cardRepository.getFolderNameByFolderid(folderid);
    }
}
