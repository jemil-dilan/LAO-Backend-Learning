package org.example.gestion_utilisateur.mapper;

import org.example.gestion_utilisateur.domain.User;
import org.example.gestion_utilisateur.dto.UserDTO;
import org.example.gestion_utilisateur.dto.CreateUserDTO;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toDTO(User user);


    @BeanMapping(ignoreByDefault = true)
    User toEntity(CreateUserDTO createUserDTO);
}
