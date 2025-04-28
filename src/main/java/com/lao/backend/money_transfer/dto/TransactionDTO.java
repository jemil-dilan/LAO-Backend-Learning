package com.lao.backend.money_transfer.dto;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
public class TransactionDTO {
    private Long id;
    private BigDecimal amount;
    private String reference;
    private Status status;
    private Long senderAccountId;
    private Long receiverAccountId;
    private LocalDateTime creationDate;

    public TransactionDTO() {
    }

    public TransactionDTO(Long id, BigDecimal amount, String reference, Status status, Long senderAccountId, Long receiverAccountId, LocalDateTime creationDate) {
        this.id = id;
        this.amount = amount;
        this.reference = reference;
        this.status = status;
        this.senderAccountId = senderAccountId;
        this.receiverAccountId = receiverAccountId;
        this.creationDate = creationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getSenderAccountId() {
        return senderAccountId;
    }

    public void setSenderAccountId(Long senderAccountId) {
        this.senderAccountId = senderAccountId;
    }

    public Long getReceiverAccountId() {
        return receiverAccountId;
    }

    public void setReceiverAccountId(Long receiverAccountId) {
        this.receiverAccountId = receiverAccountId;
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDateTime creationDate) {
        this.creationDate = creationDate;
    }
}
