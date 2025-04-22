package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Enum.Role;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.member.MemberDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.book.BookCreationMapper;
import com.laoBackend.gestionaire_de_biblioteque.mapper.book.BookMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.BookRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.isA;
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

    @Test
    void createBook() {
        Book book =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        BookCreationDTO bookCreationDTO = new BookCreationDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "1234567890123L",
                10,
                20
        );

        BookDTO bookDTO = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "1234567890123L",
                10
        );
        Member member = new Member(
                1L,
                "john",
                "john@email.com",
                "logbesou",
                LocalDateTime.now(),
                null,
                Role.LIBRARIAN
        );

        when(bookRepository.existsByTitleAndAuthorAndPublisher(
                bookCreationDTO.getBookTitle(),
                bookCreationDTO.getBookAuthor(),
                bookCreationDTO.getPublisher())).thenReturn(false);
        when(memberRepository.findById(any(Long.class))).thenReturn(Optional.of(member));
        when(bookCreationMapper.toEntity(bookCreationDTO)).thenReturn(book);
        book.setCreatedOn(LocalDateTime.of(2025,2,5,10,23));
        when(bookRepository.save(any(Book.class))).thenReturn(book);
        when(bookMapper.toDto(book)).thenReturn(bookDTO);

        BookDTO result = bookService.createBook(bookCreationDTO,1L);

        assertEquals(bookDTO.getTitle(), result.getTitle());

        verify(bookRepository).existsByTitleAndAuthorAndPublisher(bookCreationDTO.getBookTitle(),
                bookCreationDTO.getBookAuthor(),
                bookCreationDTO.getPublisher());
        verify(bookRepository).findById(any(Long.class));
        verify(bookCreationMapper).toEntity(bookCreationDTO);
        verify(bookRepository).save(any(Book.class));
        verify(bookMapper).toDto(book);

    }

    @Test
    void getAllBooks() {
        Book book1 =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        Book book2 =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        BookDTO bookDTO1 = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "1234567890123L",
                10
        );
        BookDTO bookDTO2 = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "a simple book",
                10
        );

        when(bookRepository.findAll()).thenReturn(List.of(book1, book2));
        when(bookMapper.toDto(List.of(book1, book2)))
                .thenReturn(List.of(bookDTO1, bookDTO2));

        List<BookDTO> result = bookService.getAllBooks();

        assertEquals(2, result.size());

        verify(bookRepository).findAll();
        verify(bookMapper).toDto(List.of(book1, book2));
    }

    @Test
    void getBookById() {
        long memberId = 2L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN
        );
        Book book =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        BookDTO bookDTO = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "a simple book",
                10
        );
        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        when(bookRepository.findById(any(Long.class))).thenReturn(Optional.of(book));
        when(bookMapper.toDto(book)).thenReturn(bookDTO);

        BookDTO result = bookService.getBookById(1L, memberId);

        assertEquals(bookDTO.getYearPublished(), result.getYearPublished());

        verify(memberRepository).findById(memberId);
        verify(bookRepository).findById(any(Long.class));
        verify(bookMapper).toDto(book);

    }

    @Test
    void getBooksByTitle() {
        Book book =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        BookDTO bookDTO = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "a simple book",
                10
        );
        when(bookRepository.findByTitle("title")).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByTitle("title");

        assertEquals(bookDTO.getTitle(), result.get(0).getTitle());


        verify(bookRepository).findByTitle("title");
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void getBooksByAuthor() {
        Book book =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        BookDTO bookDTO = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "a simple book",
                10
        );
        when(bookRepository.findByAuthor("author")).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByAuthor("author");

        assertEquals(bookDTO.getAuthor(), result.get(0).getAuthor());

        verify(bookRepository).findByAuthor("author");
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void getBooksByGenre() {
        Book book =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        BookDTO bookDTO = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "a simple book",
                10
        );
        when(bookRepository.findByGenre("genre")).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByGenre("genre");

        assertEquals(bookDTO.getGenre(), result.get(0).getGenre());

        verify(bookRepository).findByGenre("genre");
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void getBooksByPublisher() {
        Book book =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );
        BookDTO bookDTO = new BookDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "a simple book",
                10
        );
        when(bookRepository.findByPublisher("publisher")).thenReturn(List.of(book));
        when(bookMapper.toDto(List.of(book))).thenReturn(List.of(bookDTO));

        List<BookDTO> result = bookService.getBooksByPublisher("publisher");

        assertEquals(bookDTO.getPublisher(), result.get(0).getPublisher());

        verify(bookRepository).findByPublisher("publisher");
        verify(bookMapper).toDto(List.of(book));
    }

    @Test
    void updateBook() {
        BookCreationDTO bookCreationDTO = new BookCreationDTO(
                "title",
                "author",
                "publisher",
                2023,
                "genre",
                "1234567890123L",
                10,
                20
        );

        long memberId = 1L;
        Member member = new Member(
                memberId,
                "john charle",
                "john@email.com",
                "logbaba",
                LocalDateTime.now().minusDays(9),
                LocalDateTime.now(),
                Role.LIBRARIAN
        );

        Book book =new Book(
                1L,
                "title",
                "author",
                "publisher",
                2023,
                10,
                20
        );

        Book updatedBook =new Book(
                1L,
                "josh",
                "author",
                "publisher",
                2023,
                10,
                20
        );

        BookDTO bookDTO = new BookDTO(
                "josh",
                "author",
                "publisher",
                2023,
                "genre",
                "a simple book",
                10
        );

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        when(bookRepository.existsById(any(Long.class))).thenReturn(true);
        when(bookCreationMapper.toEntity(bookCreationDTO)).thenReturn(book);
        when(bookRepository.save(any(Book.class))).thenReturn(updatedBook);
        when(bookMapper.toDto(updatedBook)).thenReturn(bookDTO);

        BookDTO result = bookService.updateBook(1L,bookCreationDTO, memberId);

        assertEquals(result.getTitle(), bookDTO.getTitle());
        assertEquals(result.getAuthor(), bookDTO.getAuthor());
        assertEquals(result.getDescription(), bookDTO.getDescription());

        verify(memberRepository).findById(memberId);
        verify(bookRepository).existsById(any(Long.class));
        verify(bookCreationMapper).toEntity(bookCreationDTO);
        verify(bookRepository).save(any(Book.class));
        verify(bookMapper).toDto(updatedBook);


    }

    @Test
    void deleteBook() {
        long id = 1L;
        long memberId = 2L;
        Member member = new Member(
                memberId,
                "Roy",
                "roy@email.com",
                "ndokoti",
                LocalDateTime.now().minusDays(5),
                null,
                Role.LIBRARIAN
        );

        when(memberRepository.findById(memberId)).thenReturn(Optional.of(member));
        doNothing().when(bookRepository).deleteById(any(Long.class));
        bookService.deleteBook(id,memberId);

        verify(bookRepository).deleteById(id);
    }
}