package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.Folder;
import com.mainpackage.PasswordManager.repository.FolderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Service
public class FolderService {
    @Autowired
    private FolderRepository folderRepository;

    public List<Optional<Folder>> getAllFoldersBySafeId(Long safeid) {
        return folderRepository.findBySafeId(safeid);
    }

    public void save(Folder folder) {
        folderRepository.save(folder);
    }

    public void deleteFolderById(Long userid) {
        folderRepository.deleteFolderByUserId(userid);
    }
}
