package com.lao.backend.money_transfer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class CreateAccountDTO {
    private Long userId;
    private BigDecimal balance;

    public CreateAccountDTO(Long userId, BigDecimal balance) {
        this.userId = userId;
        this.balance = balance;
    }

    public CreateAccountDTO() {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }
}
