package com.lao.backend.money_transfer.dto;

import com.lao.backend.money_transfer.domain.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private BigDecimal balance;
    private String ownerName;
    private List<Transaction> accountTransactions = new ArrayList<>();
}
