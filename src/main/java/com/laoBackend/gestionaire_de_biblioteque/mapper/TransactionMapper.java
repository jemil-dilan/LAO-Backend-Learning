package com.laoBackend.gestionaire_de_biblioteque.mapper;

import com.laoBackend.gestionaire_de_biblioteque.domain.Transaction;
import com.laoBackend.gestionaire_de_biblioteque.dto.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mapping(target = "memberName", source = "member.name")
    @Mapping(target = "bookTitle", source = "book.title")
    TransactionDTO toDTO (Transaction transaction);

    List<TransactionDTO> toDTO(List<Transaction> transactions);

}
