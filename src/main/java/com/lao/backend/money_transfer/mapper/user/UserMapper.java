package com.lao.backend.money_transfer.mapper.user;

import com.lao.backend.money_transfer.domain.User;
import com.lao.backend.money_transfer.dto.UserDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "userAccount.accountNumber", source = "accountNumber")
    @Mapping(target = "updatedDate", ignore = true)
    @Mapping(target = "creationDate", ignore = true)
    User toUser (UserDTO userDTO);

    @Mapping(target = "accountNumber", source = "userAccount.accountNumber")
    UserDTO toUserDTO(User user);
}
