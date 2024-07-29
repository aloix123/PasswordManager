package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.SecureNote;
import com.mainpackage.PasswordManager.repository.SecureNoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecureNoteService {
    @Autowired
    private SecureNoteRepository secureNoteRepository;

    public List<Optional<SecureNote>> getSecureNotesByFolderId(Long folderId){
        return secureNoteRepository.getSecureNoteByFolderid(folderId);
    }
    public void createSEcureNoteForFolder(SecureNote secureNote, Long folderId){
        secureNote.setFolderid(folderId);
        secureNoteRepository.save(secureNote);
    }
    public void deleteSecureNoteById(Long secureNoteId){
        secureNoteRepository.deleteById(secureNoteId);
    }

    public List<Optional<SecureNote>> getAllSecureNotesByuserId(Long userId){
        return secureNoteRepository.getSEcureNoteByUserId(userId);
    }

    public String getSafeNameByfolderI(Long folderId){
        return secureNoteRepository.getSafeNameByFolderid(folderId);
    }

    public String getFolderNameByFolderId(Long folderId){
        return secureNoteRepository.getFolderNameByfolderId(folderId);
    }

    public void deleteByUserId(Long userid){
        secureNoteRepository.deleteByCustomUserId(userid);
    }
}
