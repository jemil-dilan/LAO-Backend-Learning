package com.lao.backend.money_transfer.mapper;

import com.lao.backend.money_transfer.domain.Transaction;
import com.lao.backend.money_transfer.dto.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {


    @Mapping(target = "senderAccount.id", source = "receiverAccountId")
    @Mapping(target = "receiverAccount.id", source = "receiverAccountId")
    Transaction toEntity(TransactionDTO transactionDTO);

    @Mapping(target = "senderAccountId", source = "senderAccount.id")
    @Mapping(target = "receiverAccountId", source = "receiverAccount.id")
    TransactionDTO toDTO (Transaction transaction);
}
