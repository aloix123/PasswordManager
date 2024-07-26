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

    @Query("SELECT sn FROM SecureNote sn JOIN Folder f ON sn.folderid = f.folderid JOIN Safe s ON f.safeid = s.safeid JOIN CustomUser u ON s.userid = u.userid WHERE u.userid = :userid")
    List<Optional<SecureNote>> getSEcureNoteByUserId(@Param("userid") Long userid);

    @Query("SELECT s.name FROM Safe s JOIN Folder f ON s.safeid = f.safeid WHERE f.folderid = :folderid")
    String getSafeNameByFolderid(@Param("folderid") Long folderid);

    @Query("SELECT f.name FROM Folder f WHERE f.folderid = :folderid")
    String getFolderNameByfolderId(@Param("folderid") Long folderid);
}
