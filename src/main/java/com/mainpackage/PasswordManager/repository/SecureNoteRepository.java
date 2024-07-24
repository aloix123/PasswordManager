package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.SecureNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SecureNoteRepository extends JpaRepository<SecureNote, Long> {
    @Query("SELECT sn FROM SecureNote sn WHERE sn.folderid = :folderid")
    List<Optional<SecureNote>> getSecureNoteByFolderid(@Param("folderid") Long folderid);
}
