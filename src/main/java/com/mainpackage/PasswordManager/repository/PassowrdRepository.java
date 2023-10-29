package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.Password;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassowrdRepository extends CrudRepository<Password,Long> {
}
