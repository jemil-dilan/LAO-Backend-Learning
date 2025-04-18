package com.laoBackend.gestionaire_de_biblioteque.repository;

import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Status;
import com.laoBackend.gestionaire_de_biblioteque.domain.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByMemberId(Long userId);

    List<Transaction> findAllByBookId(Long bookId);

    List<Transaction> findAllByStatus(Status status);
}
