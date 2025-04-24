package com.laoBackend.gestionaire_de_biblioteque.mapper.book;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")

public interface BookMapper {
    BookDTO toDto(Book book);

    List<BookDTO> toDto(List<Book> byTitle);
}
