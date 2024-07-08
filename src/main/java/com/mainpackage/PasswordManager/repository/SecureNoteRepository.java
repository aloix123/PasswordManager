package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.SecureNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecureNoteRepository extends JpaRepository<SecureNote, Long> {
}
