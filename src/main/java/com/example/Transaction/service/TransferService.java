package com.example.Transaction.service;

import com.example.Transaction.entity.Account;
import com.example.Transaction.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class TransferService {

    private final AccountRepository accountRepository;


    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transferMoney(String fromAccountNumber, String toAccountNumber, double amount){
        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber);
        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber);

        if (fromAccountNumber == null || toAccount == null){
            throw new IllegalArgumentException("invalid account number");
        }

        if (fromAccount.getBalance() < amount) {
            throw new IllegalStateException("Insufficient funds.");
        }

        fromAccount.setBalance(fromAccount.getBalance() - amount);
        toAccount.setBalance(toAccount.getBalance() + amount);

        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);

    }
}
