package com.jaspercode.banking_app.Service;

import java.util.List;

import com.jaspercode.banking_app.Dto.AccountDto;

public interface AccountService {
    AccountDto createAccount(AccountDto accountDto);

    AccountDto getAccountById(String id);

    AccountDto deposit(String id, double Amount);

    AccountDto withdraw(String id, double Amount);

    List <AccountDto> getAllAccounts();

    void  deleteAccount(String id);
}
