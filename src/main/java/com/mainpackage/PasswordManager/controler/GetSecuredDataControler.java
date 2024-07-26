package com.mainpackage.PasswordManager.controler;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.mainpackage.PasswordManager.Util.UserUtil;
import com.mainpackage.PasswordManager.model.Card;
import com.mainpackage.PasswordManager.model.LoginData;
import com.mainpackage.PasswordManager.model.SecureNote;
import com.mainpackage.PasswordManager.repository.LoginDataRepository;
import com.mainpackage.PasswordManager.service.CardServiceImp;
import com.mainpackage.PasswordManager.service.LoginDataServiceImp;
import com.mainpackage.PasswordManager.service.SecureNoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class GetSecuredDataControler {

    @GetMapping("alldata")
    public List<ObjectNode> getAllData(){
        List<ObjectNode> bunchOfObjectNodes = new ArrayList<>();
        bunchOfObjectNodes.addAll(getLoginDataElement());
        bunchOfObjectNodes.addAll(getCardElement());
        bunchOfObjectNodes.addAll(getSecureNoteElement());
        return bunchOfObjectNodes;
    }

    @Autowired
    private LoginDataServiceImp loginDataServiceImp;

    public List<ObjectNode> getLoginDataElement(){
        List<ObjectNode> bunchOfObjectNodes = new ArrayList<>();
        List<Optional<LoginData>> allLoginData=loginDataServiceImp.getAllLoginDataByUserId(UserUtil.getId());
        for (Optional<LoginData> loginData : allLoginData) {
            ObjectNode loginDataNode = new ObjectMapper().createObjectNode();
            loginDataNode.put("element","login data");
            loginDataNode.put("Name",loginData.get().getName());
            loginDataNode.put("safe",loginDataServiceImp.getSafeNamebyfolderId(loginData.get().getFolderid()));;
            loginDataNode.put("folder",loginDataServiceImp.getFolderNameByfolderId(loginData.get().getFolderid()));
            bunchOfObjectNodes.add(loginDataNode);
        }

        return bunchOfObjectNodes;
    }

    @Autowired
    private CardServiceImp cardServiceImp;

    public List<ObjectNode> getCardElement(){
        List<ObjectNode> bunchOfObjectNodes = new ArrayList<>();
        List<Optional<Card>> allCards=cardServiceImp.getAllCardsByuserId(UserUtil.getId());
        for (Optional<Card> card : allCards) {
            ObjectNode cardNode = new ObjectMapper().createObjectNode();
            cardNode.put("element","card");
            cardNode.put("Name",card.get().getName());
            cardNode.put("safe",cardServiceImp.getSafeNameByfolderId(card.get().getFolderid()));
            cardNode.put("folder",cardServiceImp.getFolderName(card.get().getFolderid()));
            bunchOfObjectNodes.add(cardNode);
        }

        return bunchOfObjectNodes;
    }

    @Autowired
    private SecureNoteService secureNoteService;

    public List<ObjectNode> getSecureNoteElement(){
        List<ObjectNode> bunchOfObjectNodes = new ArrayList<>();
        List<Optional<SecureNote>> allSecureNotes=secureNoteService.getAllSecureNotesByuserId(UserUtil.getId());
        for (Optional<SecureNote> secureNote : allSecureNotes) {
            ObjectNode secureNoteNode = new ObjectMapper().createObjectNode();
            secureNoteNode.put("element","secure note");
            secureNoteNode.put("Name",secureNote.get().getName());
            secureNoteNode.put("safe",secureNoteService.getSafeNameByfolderI(secureNote.get().getFolderid()));
            secureNoteNode.put("folder",secureNoteService.getFolderNameByFolderId(secureNote.get().getFolderid()));
            bunchOfObjectNodes.add(secureNoteNode);
        }
        return bunchOfObjectNodes;
    }
}
