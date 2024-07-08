package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.CustomUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomUserRepository extends JpaRepository<CustomUser,Long> {
}
