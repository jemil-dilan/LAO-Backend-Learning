package com.lao.backend.money_transfer.testBuilder.account;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.domain.User;
import com.lao.backend.money_transfer.testBuilder.user.UserBuilder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
public class AccountBuilder {
    private final UserBuilder userBuilder = new UserBuilder();
    private Long id = 2L;
    private final String accountNumber = UUID.randomUUID().toString();
    private BigDecimal balance = BigDecimal.valueOf(20000);
    private User user = userBuilder.build();
    private List<Transaction> accountTransactions = new ArrayList<>();
    private LocalDateTime createdAt = LocalDateTime.of(2021,12,5,10,50);
    private LocalDateTime updatedAt = createdAt.plusMonths(5);
    public AccountBuilder withId(Long id){
        this.id = id;
        return this;
    }
    public AccountBuilder withBalance(BigDecimal balance){
        this.balance = balance;
        return this;
    }
    public AccountBuilder withUser(User user){
        this.user = user;
        return this;
    }
    public AccountBuilder withAccTransaction(List<Transaction> transactions){
        this.accountTransactions = transactions;
        return this;
    }
    public AccountBuilder withCreationDate(LocalDateTime creationDate){
        this.createdAt = creationDate;
        return this;
    }
    public AccountBuilder withUpdatedDate(LocalDateTime updatedDate){
        this.updatedAt = updatedDate;
        return this;
    }

    public Account build(){
        return new Account(id,accountNumber,balance,user,accountTransactions,createdAt,updatedAt);
    }

}
