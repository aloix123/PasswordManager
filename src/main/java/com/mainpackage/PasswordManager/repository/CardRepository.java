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
}
