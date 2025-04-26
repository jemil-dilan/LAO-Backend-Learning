package com.lao.backend.money_transfer.dto;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    private BigDecimal amount;
    private String reference;
    private Status status;
    private Account senderAccount;
    private Account recieverAccount;


}
