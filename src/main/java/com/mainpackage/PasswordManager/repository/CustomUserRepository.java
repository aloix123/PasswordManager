package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser,Long> {
    @Query("SELECT u FROM CustomUser u WHERE u.login =:login AND u.mainPassword = :mainPassword")
    Optional<CustomUser> findByLoginAndPassword(String login, String mainPassword);
}
