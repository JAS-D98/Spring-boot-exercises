package com.jaspercode.banking_app.Service.impl;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.jaspercode.banking_app.Dto.AccountDto;
import com.jaspercode.banking_app.Entity.Account;
import com.jaspercode.banking_app.Repository.AccountRepository;
import com.jaspercode.banking_app.Service.AccountService;
import com.jaspercode.banking_app.exception.AccountException;
import com.jaspercode.banking_app.mapper.AccountMapper;

@Service
public class AccountServiceImpl implements AccountService {
    
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository=accountRepository;
    }


    @Override
    public AccountDto createAccount(AccountDto accountDto){

        Account account=AccountMapper.mapToAccount(accountDto);
        Account savedAccount=accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto getAccountById(String id){
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exist"));
        return AccountMapper.mapToAccountDto(account);
    }

    @Override
    public AccountDto deposit(String id, double amount){
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exist"));
        
        double total=account.getBalance()+amount;
        account.setBalance(total);
        Account savedAccount = accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto withdraw(String id, double amount){
        Account account=accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exist"));

        if(account.getBalance() < amount){
            throw new AccountException("Insufficient funds in your account");
        }

        double total=account.getBalance()-amount;
        account.setBalance(total);
        Account savedAccount=accountRepository.save(account);

        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public List<AccountDto> getAllAccounts(){

        List<Account> accounts=accountRepository.findAll();

        return accounts.stream().map((account)-> AccountMapper.mapToAccountDto(account)).collect(Collectors.toList());
    }

    @Override
    public void deleteAccount(String id){
        accountRepository.findById(id).orElseThrow(() -> new AccountException("Account does not exist"));
        
        accountRepository.deleteById(id);
    }

}
