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
    @Query("SELECT ld.name FROM LoginData ld WHERE ld.folderid = :folderid")
    String getfolderNameByFolderId(@Param("folderid") Long folderid);

    @Query("SELECT s.name FROM Safe s JOIN Folder f ON s.safeid = f.safeid JOIN LoginData ld ON f.folderid = ld.folderid WHERE ld.folderid = :folderid")
    String getSafeNameByFolderId(@Param("folderid") Long folderid);

    @Query("SELECT ld FROM LoginData ld JOIN Folder f ON ld.folderid = f.folderid JOIN Safe s ON f.safeid = s.safeid JOIN CustomUser u ON s.userid = u.userid WHERE u.userid = :userid")
    List<Optional<LoginData>> getLoginDataByCustomUserId(@Param("userid") Long userid);
}
