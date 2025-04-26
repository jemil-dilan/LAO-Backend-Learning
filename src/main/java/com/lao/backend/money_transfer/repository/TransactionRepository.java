package com.lao.backend.money_transfer.repository;

import com.lao.backend.money_transfer.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}
