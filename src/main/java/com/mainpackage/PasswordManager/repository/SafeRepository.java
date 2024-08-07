package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.Safe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Repository
public interface SafeRepository extends JpaRepository<Safe, Integer> {
    @Query("SELECT s FROM Safe s WHERE s.userid = :userid")
    List<Optional<Safe>> getSafesByUserid(@Param("userid") Long userid);
    @Transactional
    @Modifying
    @Query("DELETE FROM Safe s WHERE s.userid = :userid")
    void deleteSafeByUserid(@Param("userid") Long userid);

}
