package com.jaspercode.banking_app.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jaspercode.banking_app.Entity.Account;

public interface AccountRepository extends JpaRepository<Account, String>{
}
