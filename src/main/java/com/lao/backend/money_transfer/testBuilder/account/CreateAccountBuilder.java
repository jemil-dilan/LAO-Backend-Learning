package com.lao.backend.money_transfer.testBuilder.account;

import com.lao.backend.money_transfer.dto.CreateAccountDTO;

import java.math.BigDecimal;

public class CreateAccountBuilder {
    private final AccountBuilder accountBuilder = new AccountBuilder();

    private Long userId = accountBuilder.getUser().getId();
    private BigDecimal balance = accountBuilder.getBalance();

    public CreateAccountBuilder withBalance(BigDecimal balance){
        this.balance = balance;
        return this;
    }
    public CreateAccountDTO build(){
        return new CreateAccountDTO(userId,balance);
    }
}
