package com.qa.AccountManagement.repository;

import com.qa.AccountManagement.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {
}
