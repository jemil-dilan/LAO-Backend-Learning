package com.lao.backend.money_transfer.mapper.user;

import com.lao.backend.money_transfer.domain.User;
import com.lao.backend.money_transfer.dto.CreateUserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CreateUserMapper {

    @Mapping(target = "userAccount", ignore = true)
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    User toUser(CreateUserDTO createUserDTO);

    CreateUserDTO toCreatUser(User user);
}
