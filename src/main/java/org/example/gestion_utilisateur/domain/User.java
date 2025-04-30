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
    @GeneratedValue(strategy = GenerationType.UUID)
    private Long id;
    @Column(name = "User First Name")
    private  String firstName;
    @Column(name = "User Last Name")
    private String lastName;
    @Column(name = "Email")
    private String email;
    @Column(name = "Creation Date")
    private LocalDateTime creationDate = LocalDateTime.now();

}
