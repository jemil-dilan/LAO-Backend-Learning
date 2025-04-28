package com.lao.backend.money_transfer.repository;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.dto.TransactionDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findAllBySenderAccountOrReceiverAccount(Account senderAccount, Account receiverAccount);
}
