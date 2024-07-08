package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.Safe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SafeRepository extends JpaRepository<Safe, Integer> {
}
