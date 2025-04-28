package com.lao.backend.money_transfer.mapper;

import com.lao.backend.money_transfer.domain.Account;
import com.lao.backend.money_transfer.dto.AccountDTO;
import com.lao.backend.money_transfer.dto.CreateAccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    @Mapping(target = "ownerName", source = "user.name")
    AccountDTO toDTO (Account account);




    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "updatedTime", ignore = true)
    @Mapping(target = "createdAt", ignore = true)
    @Mapping(target = "accountTransactions", ignore = true)
    @Mapping(target = "accountNumber", ignore = true)
    @Mapping(target = "id", ignore = true)
    Account toEntityByCreation(CreateAccountDTO createAccountDTO);
}
