package com.lao.backend.money_transfer.testBuilder.account;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.domain.User;
import com.lao.backend.money_transfer.dto.AccountDTO;
import com.lao.backend.money_transfer.testBuilder.user.UserBuilder;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class AccountDTOBuilder {
    private final AccountBuilder accountBuilder = new AccountBuilder();
    private Long id = 2L;
    private final String accountNumber = accountBuilder.getAccountNumber();
    private BigDecimal balance = accountBuilder.getBalance();
    private String ownerName = accountBuilder.getUser().getName() ;
    private List<Transaction> accountTransactions = accountBuilder.getAccountTransactions();

    public AccountDTOBuilder withId(Long id){
        this.id = id;
        return this;
    }
    public AccountDTOBuilder withBalance(BigDecimal balance){
        this.balance = balance;
        return this;
    }
    public AccountDTOBuilder withUser(String ownerName){
        this.ownerName = ownerName;
        return this;
    }
    public AccountDTOBuilder withAccTransaction(List<Transaction> transactions){
        this.accountTransactions = transactions;
        return this;
    }

    public AccountDTO build(){
        return new AccountDTO(id,accountNumber,balance,ownerName,accountTransactions);
    }
}
