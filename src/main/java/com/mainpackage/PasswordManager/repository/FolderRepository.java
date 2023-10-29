package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.Folder;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends CrudRepository<Folder,Long> {
}
