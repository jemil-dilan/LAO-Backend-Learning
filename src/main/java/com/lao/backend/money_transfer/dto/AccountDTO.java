package com.lao.backend.money_transfer.dto;

import com.lao.backend.money_transfer.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private String ownerName;
    private List<Transaction> accountTransactions = new ArrayList<>();

    public AccountDTO() {
    }

    public AccountDTO(Long id, String accountNumber, BigDecimal balance, String ownerName, List<Transaction> accountTransactions) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.ownerName = ownerName;
        this.accountTransactions = accountTransactions;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Transaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<Transaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }
}
