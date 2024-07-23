package com.mainpackage.PasswordManager.controler;

import com.mainpackage.PasswordManager.model.Folder;
import com.mainpackage.PasswordManager.service.FolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FolderControler {
    @Autowired
    private FolderService folderService;

    @GetMapping("safes/{id}/folders")
    public ResponseEntity<List<Optional<Folder>>> getFolders(@PathVariable("id") Long id){
        return new ResponseEntity<>(folderService.getAllFoldersBySafeId(id), HttpStatus.OK);
    }

    @PostMapping("safes/{id}/folders/add")
    public ResponseEntity<String> addFolder(@PathVariable("id") Long id, @RequestBody Folder folder){
        Folder newfolder=new Folder();
        newfolder.setSafeid(id);
        newfolder.setName(folder.getName());
        System.out.println(newfolder.getFolderid());
        folderService.save(newfolder);
        return new ResponseEntity<>("you created a folder!!", HttpStatus.CREATED);
    }
    @DeleteMapping("safes/{id}/folders/delete/{folderId}")
    public ResponseEntity<String> deleteFolder(@PathVariable("id") Long id, @PathVariable("folderId") Long folderId){
        folderService.deleteFolderById(folderId);
        return new ResponseEntity<>("you deleted a folder!!", HttpStatus.OK);
    }
}
