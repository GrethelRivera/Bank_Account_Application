package com.Grethel.BankAccountApplication.controller;

import com.Grethel.BankAccountApplication.model.Account;
import com.Grethel.BankAccountApplication.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/all")
    public ResponseEntity<Iterable<Account>> getAllAccounts() {
        Iterable<Account> allAccounts = accountRepository.findAll();
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }

    @GetMapping("/finduser/{id}")
    public ResponseEntity<Account> finduser(@PathVariable("id") Long id) {
        Account saveID = accountRepository.findById(id).get();
        return new ResponseEntity<>(saveID, HttpStatus.OK);
    }

    @PutMapping("/finduser")
    public ResponseEntity<Account> finduser(@RequestBody Account updatedAccount) {
        Account updateUser = accountRepository.save(updatedAccount);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    @DeleteMapping("/deleteuser/{id}")
    public ResponseEntity<Account> deleteuser(@PathVariable("id") Long id) {
        accountRepository.deleteById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/deletealluser")
    public ResponseEntity<Account> deleteall() {
        accountRepository.deleteAll();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/findbyname/{name}")
    public ResponseEntity<Account> findname(@PathVariable("name") String name) {
        Account findbyname = accountRepository.findByName(name);
        return new ResponseEntity<>(findbyname, HttpStatus.OK);
    }

    @GetMapping("/findbyage/{age}")
    public ResponseEntity<Account> findByAge(@PathVariable("age") int age) {
        Account userAge = accountRepository.findByAge(age);
        return new ResponseEntity<>(userAge, HttpStatus.OK);

    }

    @GetMapping("/findbalance/{balance}")
    public ResponseEntity<Account> findByBalance(@PathVariable("balance") double balance) {
        Account userBalance = accountRepository.findByBalance(balance);
        return new ResponseEntity<>(userBalance, HttpStatus.OK);
    }

    @GetMapping("/findbyaccount/{accountNumber}")
    public ResponseEntity<Account> findByAccount(@PathVariable("accountNumber") int accountNumber) {
        Account userAccount = accountRepository.findByAccountNumber(accountNumber);
        return new ResponseEntity<>(userAccount, HttpStatus.OK);

    }

    @GetMapping("/allbyaccount/{accountNumber}")
    public ResponseEntity<Iterable<Account>> getAllAccountNumber(@PathVariable("accountNumber") int accountNumber) {
        Iterable<Account> allAccounts = accountRepository.findAllByAccountNumber(accountNumber);
        return new ResponseEntity<>(allAccounts, HttpStatus.OK);
    }




}

