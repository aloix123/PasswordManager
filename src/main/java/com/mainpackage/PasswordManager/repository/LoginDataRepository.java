package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.LoginData;
import com.mainpackage.PasswordManager.model.Safe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoginDataRepository extends JpaRepository<LoginData, Long> {

    @Query("SELECT ld FROM LoginData ld WHERE ld.folderid = :folderid")
    List<Optional<LoginData>> getLoginDataByfolderId(@Param("folderid") Long folderid);




}
