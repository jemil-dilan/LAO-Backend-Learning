package com.laoBackend.gestionaire_de_biblioteque.mapper.book;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookCreationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookCreationMapper {
    @Mapping(target = "updatedOn", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdOn", ignore = true)
    Book toEntity(BookCreationDTO bookCreationDTO);
}
