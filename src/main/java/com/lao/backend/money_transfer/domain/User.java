package com.lao.backend.money_transfer.domain;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "Name")
    private String name;
    @Column(name = "Email")
    private String email;
    @Column(name = "Address")
    private String address;
    @Column(name = "Date of Birth")
    private LocalDate dateOfBirth;
    @Column(name = "Contact")
    private String phoneNumber;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    @JoinColumn(name = "user_account_id")
    private Account userAccount;
    @Column(name = "Creation Date")
    private LocalDateTime creationDate;
    @Column(name = "Updated Date")
    private LocalDateTime updatedDate;
}
