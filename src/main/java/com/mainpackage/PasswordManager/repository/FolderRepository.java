package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.Folder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface FolderRepository extends JpaRepository<Folder, Integer> {
    @Query("SELECT f FROM Folder f WHERE f.safeid = ?1")
    List<Optional<Folder>> findBySafeId(Long safeid);
    @Transactional
    @Modifying
    @Query("DELETE FROM Folder f WHERE f.safeid IN (SELECT s.safeid FROM Safe s WHERE s.userid = :userid)")
    void deleteFolderByUserId(@Param("userid")Long userid);
}
