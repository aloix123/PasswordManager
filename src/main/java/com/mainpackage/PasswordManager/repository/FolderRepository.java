package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Integer> {
}
