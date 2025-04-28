package com.lao.backend.money_transfer.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
//@Data
//@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Account Number")
    private String accountNumber = UUID.randomUUID().toString();
    @Column(name = "Account Balance")
    private BigDecimal balance;
    @OneToOne()
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> accountTransactions = new ArrayList<>();
    @Column(name = "Creation Date")
    private LocalDateTime createdAt;
    @Column(name = "Updated Date")
    private LocalDateTime updatedTime;

    public Account() {
    }

    public Account(Long id, String accountNumber, BigDecimal balance, User user, List<Transaction> accountTransactions, LocalDateTime createdAt, LocalDateTime updatedTime) {
        this.id = id;
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.user = user;
        this.accountTransactions = accountTransactions;
        this.createdAt = createdAt;
        this.updatedTime = updatedTime;
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Transaction> getAccountTransactions() {
        return accountTransactions;
    }

    public void setAccountTransactions(List<Transaction> accountTransactions) {
        this.accountTransactions = accountTransactions;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(LocalDateTime updatedTime) {
        this.updatedTime = updatedTime;
    }
}
