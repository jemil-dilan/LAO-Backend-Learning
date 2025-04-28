package com.lao.backend.money_transfer.testBuilder.transaction;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.domain.enums.Status;
import com.lao.backend.money_transfer.testBuilder.account.AccountBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionBuilder {
    private final AccountBuilder accountBuilder = new AccountBuilder();
    private Long id = 1L;
    private BigDecimal amount = BigDecimal.valueOf(20000);
    private String reference = "new transfer";
    private Status status = Status.COMPLETED;
    private Account senderAccount = accountBuilder.build();
    private Account recieverAccount = accountBuilder.build();
    private LocalDateTime creationDate = LocalDateTime.of(2022,1,2,13,2);


    public TransactionBuilder withId(Long Id){
        this.id = id;
        return this;
    }
    public TransactionBuilder withAmount(BigDecimal amount){
        this.amount = amount;
        return this;
    }
    public TransactionBuilder withReference(String reference){
        this.reference = reference;
        return this;
    }
    public TransactionBuilder withStatus(Status status){
        this.status = status;
        return this;
    }
    public TransactionBuilder withSenderAccount(Account senderAccount){
        this.senderAccount = senderAccount;
        return this;
    }
    public TransactionBuilder withReceiverAccount(Account recieverAccount){
        this.recieverAccount = recieverAccount;
        return this;
    }
    public TransactionBuilder withCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
        return this;
    }

    public Transaction build(){
        return new Transaction(id,amount,reference,status,senderAccount,recieverAccount,creationDate);
    }

}
