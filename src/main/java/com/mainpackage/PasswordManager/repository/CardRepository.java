package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.Card;
import com.mainpackage.PasswordManager.model.SecureNote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CardRepository extends JpaRepository<Card,Long> {
    @Query("SELECT c FROM Card c WHERE c.folderid = :folderid")
    List<Optional<Card>> getCardsByFolderid(@Param("folderid") Long folderid);

    @Query("SELECT s.name FROM Safe s JOIN Folder f ON s.safeid = f.safeid WHERE f.folderid = :folderid")
    String getSafeNameByFolderid(@Param("folderid") Long folderid);

    @Query("SELECT c FROM Card c JOIN Folder f ON c.folderid = f.folderid JOIN Safe s ON f.safeid = s.safeid JOIN CustomUser u ON s.userid = u.userid WHERE u.userid = :userid")
    List<Optional<Card>> getAllCardsBycustomUserId(@Param("userid") Long userid);

    @Query("SELECT f.name FROM Folder f WHERE f.folderid = :folderid")
    String getFolderNameByFolderid(@Param("folderid") Long folderid);
}
