package com.lao.backend.money_transfer.testBuilder.transaction;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.domain.enums.Status;
import com.lao.backend.money_transfer.dto.TransactionDTO;
import com.lao.backend.money_transfer.testBuilder.account.AccountBuilder;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class TransactionDTOBuilder {
    private AccountBuilder accountBuilder = new AccountBuilder();
    private Long id = 1L;
    private BigDecimal amount = BigDecimal.valueOf(20000);
    private String reference = "new transfer";
    private Status status = Status.COMPLETED;
    private Long senderAccountId = accountBuilder.build().getId();
    private Long recieverAccountId = accountBuilder.build().getId();
    private LocalDateTime creationDate = LocalDateTime.of(2022,1,2,13,2);

    public TransactionDTOBuilder withId(Long Id){
        this.id = id;
        return this;
    }
    public TransactionDTOBuilder withAmount(BigDecimal amount){
        this.amount = amount;
        return this;
    }
    public TransactionDTOBuilder withReference(String reference){
        this.reference = reference;
        return this;
    }
    public TransactionDTOBuilder withStatus(Status status){
        this.status = status;
        return this;
    }
    public TransactionDTOBuilder withSenderAccount(Long senderAccountId){
        this.senderAccountId = senderAccountId;
        return this;
    }
    public TransactionDTOBuilder withReceiverAccount(Long receiverAccountId){
        this.recieverAccountId = receiverAccountId;
        return this;
    }
    public TransactionDTOBuilder withCreationDate(LocalDateTime creationDate){
        this.creationDate = creationDate;
        return this;
    }

    public TransactionDTO build(){
        return new TransactionDTO(id,amount,reference,status,senderAccountId,recieverAccountId,creationDate);
    }
}
