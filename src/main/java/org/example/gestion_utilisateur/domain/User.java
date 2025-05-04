package org.example.gestion_utilisateur.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Users")
public class User{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "First_Name", nullable = false)
    private  String firstName;
    @Column(name = "Last_Name", nullable = false)
    private String lastName;
    @Column(name = "User_Email", nullable = false, unique = true)
    private String email;
    @Column(name = "Creation_Date", nullable = false, updatable = false)
    private LocalDateTime creationDate = LocalDateTime.now();
    @Column(name = "Last_Updated_Date")
    private LocalDateTime lastUpdatedDate;
}
