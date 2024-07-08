package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.LoginData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDataRepository extends JpaRepository<LoginData, Long> {
}
