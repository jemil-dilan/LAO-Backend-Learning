package com.lao.backend.money_transfer.repository;

import com.lao.backend.money_transfer.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
