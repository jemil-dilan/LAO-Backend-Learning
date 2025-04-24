package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.book.BookCreationMapper;
import com.laoBackend.gestionaire_de_biblioteque.mapper.book.BookMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.BookRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.BookBuilder;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.BookCreationBuilder;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.BookDTOBuilder;
import com.laoBackend.gestionaire_de_biblioteque.testBuilders.MemberBuilder;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class BookServiceTest {
    @Mock
    MemberRepository memberRepository;
    @Mock
    BookRepository bookRepository;
    @Mock
     BookCreationMapper bookCreationMapper;
    @Mock
    BookMapper bookMapper;

    @InjectMocks
    BookService bookService;

    BookBuilder bookBuilder = new BookBuilder();
    BookCreationBuilder bookCreationBuilder = new BookCreationBuilder();
    BookDTOBuilder bookDTOBuilder = new BookDTOBuilder();
    MemberBuilder memberBuilder = new MemberBuilder();

    @Test
    void createBook() {
        Book book = bookBuilder.build();
        BookCreationDTO bookCreationDTO = bookCreationBuilder.build();
        BookDTO bookDTO = bookDTOBuilder.build();
        Member member = memberBuilder.withRole(Role.LIBRARIAN).build();

        when(bookRepository.existsByTitleAndAuthorAndPublisher(
                bookCreationDTO.getTitle(),
                bookCreationDTO.getAuthor(),
                bookCreationDTO.getPublisher())).thenReturn(false);
        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
        when(bookCreationMapper.toEntity(bookCreationDTO)).thenReturn(book);
        book.setCreatedOn(LocalDateTime.of(2025,2,5,10,23));
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        when(bookMapper.toDto(any(Book.class))).thenReturn(bookDTO);

        BookDTO result = bookService.createBook(bookCreationDTO,1L);

        assertEquals(bookDTO.getTitle(), result.getTitle());
        assertEquals(bookDTO.getAuthor(), result.getAuthor());
        assertEquals(bookDTO.getDescription(), result.getDescription());
        assertEquals(bookDTO.getGenre(), result.getGenre());
        assertEquals(bookDTO.getPublisher(), result.getPublisher());
        assertEquals(bookDTO.getAvailableCopies(), result.getAvailableCopies());
        assertEquals(bookDTO.getYearPublished(), result.getYearPublished());
        assertThat(result).isEqualTo(bookDTO);

        verify(bookRepository).existsByTitleAndAuthorAndPublisher(bookCreationDTO.getTitle(),
                bookCreationDTO.getAuthor(),
                bookCreationDTO.getPublisher());
        verify(memberRepository).findById(anyLong());
        verify(bookCreationMapper).toEntity(bookCreationDTO);
        verify(bookRepository).save(any(Book.class));
        verify(bookMapper).toDto(book);

    }

    @Test
    void getAllBooks() {
        Book book1 = bookBuilder.build();

        Book book2 = bookBuilder.withTitle("Snowfall").withAuthor("Jerome")
                .withId(2L).withPublisher("Mapped").build();

        BookDTO bookDTO1 = bookDTOBuilder.build();
        BookDTO bookDTO2 = bookDTOBuilder.withTitle("Snowfall").withAuthor("Jerome")
                .withId(2L).withPublisher("Mapped").build();

        when(bookRepository.findAll()).thenReturn(List.of(book1, book2));
        when(bookMapper.toDto(book1)).thenReturn(bookDTO1);
        when(bookMapper.toDto(book2)).thenReturn(bookDTO2);

        List<BookDTO> result = bookService.getAllBooks();

        verify(bookRepository, times(1)).findAll();
        assertThat(result).hasSize(2).contains(bookDTO1, bookDTO2);
        assertEquals(bookDTO1.getTitle(), result.getFirst().getTitle());
        assertEquals(bookDTO1.getAuthor(), result.getFirst().getAuthor());
        assertEquals(bookDTO1.getDescription(), result.getFirst().getDescription());
        assertEquals(bookDTO1.getGenre(), result.getFirst().getGenre());
        assertEquals(bookDTO1.getPublisher(), result.getFirst().getPublisher());
        assertEquals(bookDTO1.getAvailableCopies(), result.getFirst().getAvailableCopies());
        assertEquals(bookDTO1.getYearPublished(), result.getFirst().getYearPublished());

        assertEquals(bookDTO2.getTitle(), result.get(1).getTitle());
        assertEquals(bookDTO2.getAuthor(), result.get(1).getAuthor());
        assertEquals(bookDTO2.getDescription(), result.get(1).getDescription());
        assertEquals(bookDTO2.getGenre(), result.get(1).getGenre());
        assertEquals(bookDTO2.getPublisher(), result.get(1).getPublisher());
        assertEquals(bookDTO2.getAvailableCopies(), result.get(1).getAvailableCopies());
        assertEquals(bookDTO2.getYearPublished(), result.get(1).getYearPublished());
    }

    @Test
    void getBookById() {
        Member member = memberBuilder.withRole(Role.LIBRARIAN).build();
        Book book = bookBuilder.build();
        BookDTO bookDTO = bookDTOBuilder.build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
        when(bookRepository.findById(any(Long.class))).thenReturn(Optional.of(book));
        when(bookMapper.toDto(any(Book.class))).thenReturn(bookDTO);

        BookDTO result = bookService.getBookById(1L, 1L);

        assertEquals(bookDTO.getTitle(), result.getTitle());
        assertEquals(bookDTO.getAuthor(), result.getAuthor());
        assertEquals(bookDTO.getDescription(), result.getDescription());
        assertEquals(bookDTO.getGenre(), result.getGenre());
        assertEquals(bookDTO.getPublisher(), result.getPublisher());
        assertEquals(bookDTO.getAvailableCopies(), result.getAvailableCopies());
        assertEquals(bookDTO.getYearPublished(), result.getYearPublished());
        assertThat(result).isEqualTo(bookDTO);

        verify(memberRepository).findById(anyLong());
        verify(bookRepository).findById(any(Long.class));
        verify(bookMapper).toDto(any(Book.class));

    }

    @Test
    void getBooksByTitle() {
        Book book = bookBuilder.build();
        BookDTO bookDTO = bookDTOBuilder.build();

        when(bookRepository.findByTitle(anyString())).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByTitle("House");

        assertEquals(bookDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(bookDTO.getAuthor(), result.getFirst().getAuthor());
        assertEquals(bookDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(bookDTO.getGenre(), result.getFirst().getGenre());
        assertEquals(bookDTO.getPublisher(), result.getFirst().getPublisher());
        assertEquals(bookDTO.getAvailableCopies(), result.getFirst().getAvailableCopies());
        assertEquals(bookDTO.getYearPublished(), result.getFirst().getYearPublished());
        assertThat(result).hasSize(1).contains(bookDTO);


        verify(bookRepository).findByTitle(anyString());
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void getBooksByAuthor() {
        Book book = bookBuilder.build();
        BookDTO bookDTO = bookDTOBuilder.build();

        when(bookRepository.findByAuthor(anyString())).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByAuthor("author");

        assertThat(result).hasSize(1).contains(bookDTO);
        assertEquals(bookDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(bookDTO.getAuthor(), result.getFirst().getAuthor());
        assertEquals(bookDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(bookDTO.getGenre(), result.getFirst().getGenre());
        assertEquals(bookDTO.getPublisher(), result.getFirst().getPublisher());
        assertEquals(bookDTO.getAvailableCopies(), result.getFirst().getAvailableCopies());
        assertEquals(bookDTO.getYearPublished(), result.getFirst().getYearPublished());

        verify(bookRepository).findByAuthor("author");
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void getBooksByGenre() {
        Book book = bookBuilder.build();
        BookDTO bookDTO = bookDTOBuilder.build();

        when(bookRepository.findByGenre(anyString())).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByGenre("genre");

        assertThat(result).hasSize(1).contains(bookDTO);
        assertEquals(bookDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(bookDTO.getAuthor(), result.getFirst().getAuthor());
        assertEquals(bookDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(bookDTO.getGenre(), result.getFirst().getGenre());
        assertEquals(bookDTO.getPublisher(), result.getFirst().getPublisher());
        assertEquals(bookDTO.getAvailableCopies(), result.getFirst().getAvailableCopies());
        assertEquals(bookDTO.getYearPublished(), result.getFirst().getYearPublished());

        verify(bookRepository).findByGenre("genre");
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void getBooksByPublisher() {
        Book book = bookBuilder.build();
        BookDTO bookDTO = bookDTOBuilder.build();

        when(bookRepository.findByPublisher(anyString())).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByPublisher("publisher");

        assertThat(result).hasSize(1).contains(bookDTO);
        assertEquals(bookDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(bookDTO.getAuthor(), result.getFirst().getAuthor());
        assertEquals(bookDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(bookDTO.getGenre(), result.getFirst().getGenre());
        assertEquals(bookDTO.getPublisher(), result.getFirst().getPublisher());
        assertEquals(bookDTO.getAvailableCopies(), result.getFirst().getAvailableCopies());
        assertEquals(bookDTO.getYearPublished(), result.getFirst().getYearPublished());

        verify(bookRepository).findByPublisher("publisher");
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void updateBook() {
        BookCreationDTO bookCreationDTO = bookCreationBuilder.withTitle("Snowfall")
                .withAuthor("Jerome").withPublisher("Mapped").build();

        Member member = memberBuilder.withRole(Role.LIBRARIAN).build();

        Book updatedBook = bookBuilder.withTitle("Snowfall").withAuthor("Jerome")
                .withId(2L).withPublisher("Mapped").build();

        BookDTO bookDTO = bookDTOBuilder.withTitle("Snowfall").withAuthor("Jerome")
                .withId(2L).withPublisher("Mapped").build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
        when(bookRepository.existsById(anyLong())).thenReturn(true);
        when(bookCreationMapper.toEntity(bookCreationDTO)).thenReturn(updatedBook);
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);
        when(bookRepository.findAll()).thenReturn(List.of(updatedBook));
        when(bookMapper.toDto(updatedBook)).thenReturn(bookDTO);

        bookService.updateBook(1L,bookCreationDTO, 1L);
        List<BookDTO> result = bookService.getAllBooks();

        assertThat(result).hasSize(1).contains(bookDTO);
        assertEquals(bookDTO.getTitle(), result.getFirst().getTitle());
        assertEquals(bookDTO.getAuthor(), result.getFirst().getAuthor());
        assertEquals(bookDTO.getDescription(), result.getFirst().getDescription());
        assertEquals(bookDTO.getGenre(), result.getFirst().getGenre());
        assertEquals(bookDTO.getPublisher(), result.getFirst().getPublisher());
        assertEquals(bookDTO.getAvailableCopies(), result.getFirst().getAvailableCopies());
        assertEquals(bookDTO.getYearPublished(), result.getFirst().getYearPublished());


        verify(memberRepository).findById(anyLong());
        verify(bookRepository).existsById(anyLong());
        verify(bookCreationMapper).toEntity(bookCreationDTO);
        verify(bookRepository).save(any(Book.class));
        verify(bookRepository).findAll();
        verify(bookMapper).toDto(updatedBook);


    }

    @Test
    void deleteBook() {

        Member member = memberBuilder.withRole(Role.LIBRARIAN).build();

        when(memberRepository.findById(anyLong())).thenReturn(Optional.of(member));
        doNothing().when(bookRepository).deleteById(any(Long.class));
        bookService.deleteBook(1L,2L);

        verify(bookRepository).deleteById(any(Long.class));
    }
}