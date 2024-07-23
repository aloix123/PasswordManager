package com.mainpackage.PasswordManager.repository;


import com.mainpackage.PasswordManager.model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepository extends JpaRepository<Element,Long> {
}
