package com.Grethel.BankAccountApplication.repository;

import com.Grethel.BankAccountApplication.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
