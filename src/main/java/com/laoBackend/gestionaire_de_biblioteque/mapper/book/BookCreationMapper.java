package com.laoBackend.gestionaire_de_biblioteque.mapper.book;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookCreationDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface BookCreationMapper {
    @Mapping(target = "createdOn", ignore = true)
    @Mapping(target = "id", ignore = true)
    @Mapping(source = "bookTitle", target = "title")
    @Mapping(source = "bookAuthor", target = "author")
    @Mapping(source = "bookDescription", target = "description")
    Book toEntity(BookCreationDTO bookCreationDTO);
}
