package com.mainpackage.PasswordManager.service;

import com.mainpackage.PasswordManager.model.Safe;
import com.mainpackage.PasswordManager.repository.SafeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class SafeServiceImp {
    @Autowired
    private SafeRepository safeRepository;

    public List<Optional<Safe>> getSafesByUserId(Long userId){
        return safeRepository.getSafesByUserid(userId);
    }
    public void createSafe(Safe safe){
        safeRepository.save(safe);
    }
    public void deleteById(Long id) {
        try{
            safeRepository.deleteById(id.intValue());
        }
        catch(Exception e){
            throw new NoSuchElementException("there is no safe with that id!!");
        }
    }
    public void deleteAllByUserId(Long userid){
        safeRepository.deleteSafeByUserid(userid);
    }
}
