package com.lao.backend.money_transfer.service;

import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.domain.enums.Status;
import com.lao.backend.money_transfer.dto.TransactionDTO;
import com.lao.backend.money_transfer.mapper.TransactionMapper;
import com.lao.backend.money_transfer.repository.AccountRepository;
import com.lao.backend.money_transfer.repository.TransactionRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class TransactionService {

    private final TransactionRepository transactionRepository;
    private final TransactionMapper transactionMapper;
    private final AccountRepository accountRepository;

    public TransactionService(TransactionRepository transactionRepository, TransactionMapper transactionMapper, AccountRepository accountRepository) {
        this.transactionRepository = transactionRepository;
        this.transactionMapper = transactionMapper;
        this.accountRepository = accountRepository;
    }

    public List<TransactionDTO> getAllTransaction() {
        return transactionRepository.findAll().stream().map(transactionMapper::toDTO).toList();
    }

    public TransactionDTO getTransactionById(Long transactionId) {
        return transactionRepository.findById(transactionId).map(transactionMapper::toDTO).orElseThrow();
    }
    public List<TransactionDTO> getAccountTransactions(Long accountId){
        var account = accountRepository.findById(accountId).orElseThrow();
        return transactionRepository.findAllBySenderAccountOrReceiverAccount(account, account).stream().map(transactionMapper::toDTO).toList();
    }

    public TransactionDTO transferMoney(Long senderId, Long receiverId, BigDecimal amount){
        var sender = accountRepository.findById(senderId).orElseThrow();
        var receiver = accountRepository.findById(receiverId).orElseThrow();
        var transaction = new Transaction();
        if (sender == receiver){
            throw new IllegalArgumentException("cannot send money to yourself");
        }
        if (sender.getBalance().compareTo(amount) > 0) {
            sender.setBalance(sender.getBalance().subtract(amount));
            receiver.setBalance(receiver.getBalance().add(amount));
            accountRepository.save(sender);
            accountRepository.save(receiver);
            transaction.setSenderAccount(sender);
            transaction.setReceiverAccount(receiver);
            transaction.setReference("An ammount of " + amount + " was sent from " + sender.getUser().getName() + " to " + receiver.getUser().getName());
            transaction.setAmount(amount);
            transaction.setCreationDate(LocalDateTime.now());
            transaction.setStatus(Status.COMPLETED);
            return transactionMapper.toDTO(transactionRepository.save(transaction));
        } else {
            transaction.setSenderAccount(sender);
            transaction.setReceiverAccount(receiver);
            transaction.setCreationDate(LocalDateTime.now());
            transaction.setReference("Insufficient balance");
            transaction.setStatus(Status.FAILED);
            transactionRepository.save(transaction);
            throw new IllegalStateException("Insufficient balance");
        }
    }
}
