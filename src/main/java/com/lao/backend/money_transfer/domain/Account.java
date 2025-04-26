package com.lao.backend.money_transfer.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Account Number")
    private String accountNumber;
    @Column(name = "Account Balance")
    private BigDecimal balance;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "userAccount")
    @JoinColumn(name = "user_id")
    private User user;
    @OneToMany(cascade = CascadeType.ALL)
    private List<Transaction> accountTransactions = new ArrayList<>();
    @Column(name = "Creation Date")
    private LocalDateTime createdAt;
    @Column(name = "Updated Date")
    private LocalDateTime updatedTime;

}
