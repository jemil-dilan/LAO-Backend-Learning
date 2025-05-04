package org.example.gestion_utilisateur.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreateUserDTO {
    private String firstName;
    private String lastName;
    private String email;
}
