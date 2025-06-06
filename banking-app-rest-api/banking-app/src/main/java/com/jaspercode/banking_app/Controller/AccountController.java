package com.jaspercode.banking_app.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.jaspercode.banking_app.Dto.AccountDto;
import com.jaspercode.banking_app.Service.AccountService;
import com.jaspercode.banking_app.response.ResponseHandler;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService=accountService;
    }

    //Add account rest api
    @PostMapping
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
        return new ResponseEntity<>(accountService.createAccount(accountDto), HttpStatus.CREATED);
    }

    //Deposit Rest Api
    @PutMapping("/{id}/deposit")
    public ResponseEntity<AccountDto> deposit(@PathVariable String id, @RequestBody Map<String, Double> request){

        Double amount=request.get("amount");
        AccountDto accountDto  = accountService.deposit(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    //Withdraw rest api
    @PutMapping("/{id}/withdraw")
    public ResponseEntity<AccountDto> withdraw(@PathVariable String id, @RequestBody Map<String, Double> request){
        double amount=request.get("amount");
        AccountDto accountDto=accountService.withdraw(id, amount);

        return ResponseEntity.ok(accountDto);
    }

    // Get All Accounts rest api
    @GetMapping
    public ResponseEntity<List<AccountDto>> getAllAccounts(){

        List <AccountDto> accounts= accountService.getAllAccounts();

        return ResponseEntity.ok(accounts);
    }

    //Get Account by Id
    @GetMapping("{id}")
    public ResponseEntity<Object> getAccountById(@PathVariable String id){

        AccountDto accountDto=accountService.getAccountById(id);

        return ResponseHandler.responseBuilder("All Accounts Recovered Successfully", true, HttpStatus.OK, accountDto);
    }


    // Delete account rest api
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable String id){
        accountService.deleteAccount(id);
        return ResponseEntity.ok("Account Successfully deleted");
    }

}
