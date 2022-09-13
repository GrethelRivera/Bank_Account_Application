package com.Grethel.BankAccountApplication.repository;

import com.Grethel.BankAccountApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    Account findByName(String name);
    Account findByAge(int age);
    Account findByBalance(double balance);
    Account findByAccountNumber(int accountNumber);
    List<Account>findAllByAccountNumber(int accountNumber);
}
