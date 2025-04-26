package com.lao.backend.money_transfer.repository;


import com.lao.backend.money_transfer.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    Boolean existByEmail(String s);
}
