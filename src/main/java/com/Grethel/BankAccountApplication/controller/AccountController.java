package com.Grethel.BankAccountApplication.controller;

import com.Grethel.BankAccountApplication.model.Account;
import com.Grethel.BankAccountApplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")

public class AccountController {

    @Autowired
    private AccountRepository accountRepository;

    //C - Create - POST   - @PostMapping
    //R - Read -   GET    - @GetMapping
    //U - Update - PUT    - @PutMapping
    //D - Delete - DELETE - @DeleteMapping

    @PostMapping("/createuser")
    public ResponseEntity<Account> registerAccount(@RequestBody Account newAccount) {
        Account saveAccount = accountRepository.save(newAccount);

        return new ResponseEntity<>(saveAccount, HttpStatus.CREATED);
    }
}
