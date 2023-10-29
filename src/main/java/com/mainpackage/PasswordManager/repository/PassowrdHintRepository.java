package com.mainpackage.PasswordManager.repository;

import com.mainpackage.PasswordManager.model.PasswordHint;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassowrdHintRepository extends CrudRepository<PasswordHint,Long> {
}
