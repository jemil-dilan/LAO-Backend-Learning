package com.laoBackend.gestionaire_de_biblioteque.service;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import com.laoBackend.gestionaire_de_biblioteque.domain.Member;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookDTO;
import com.laoBackend.gestionaire_de_biblioteque.mapper.book.BookCreationMapper;
import com.laoBackend.gestionaire_de_biblioteque.mapper.book.BookMapper;
import com.laoBackend.gestionaire_de_biblioteque.repository.BookRepository;
import com.laoBackend.gestionaire_de_biblioteque.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookService {
    private final MemberRepository memberRepository;
    private BookRepository bookRepository;
    private BookCreationMapper bookCreationMapper;
    private BookMapper bookMapper;

    public BookService(BookRepository bookRepository,
                       BookCreationMapper bookCreationMapper,
                       BookMapper bookMapper, MemberRepository memberRepository) {
        this.bookRepository = bookRepository;
        this.bookCreationMapper = bookCreationMapper;
        this.bookMapper = bookMapper;
        this.memberRepository = memberRepository;
    }

    public BookDTO createBook(BookCreationDTO bookCreationDTO, Long memberId) {
        if(bookRepository.existsByTitleAndAuthorAndPublisher(
                bookCreationDTO.getBookTitle(),
                bookCreationDTO.getBookAuthor(),
                bookCreationDTO.getPublisher())) {
            throw new IllegalStateException("Book already exists");
        }
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can add a book");
        }
        Book book = bookCreationMapper.toEntity(bookCreationDTO);
        book.setCreatedOn(LocalDateTime.now());
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }
    public List<BookDTO> getAllBooks() {
        List<Book> allBooks = bookRepository.findAll();
        return bookMapper.toDto(allBooks);
    }
    public BookDTO getBookById(Long id, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalStateException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can get the book by ID");
        }
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElse(null);
    }
    public List<BookDTO> getBooksByTitle(String title) {
        List<Book> bookList = bookRepository.findByTitle(title);
        return bookMapper.toDto(bookList);
    }
    public List<BookDTO> getBooksByAuthor(String author) {
        List<Book> booksByAuthor = bookRepository.findByAuthor(author);
        return bookMapper.toDto(booksByAuthor);
    }
    public List<BookDTO> getBooksByGenre(String genre) {
        List<Book> booksByGenre = bookRepository.findByGenre(genre);
        return bookMapper.toDto(booksByGenre);
    }
    public List<BookDTO> getBooksByPublisher(String publisher) {
        List<Book> booksByPublisher = bookRepository.findByPublisher(publisher);
        return bookMapper.toDto(booksByPublisher);
    }
    public BookDTO updateBook(Long id, BookCreationDTO bookCreationDTO, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can add a book");
        }
        if (bookRepository.existsById(id)) {
            Book book = bookCreationMapper.toEntity(bookCreationDTO);
            book.setId(id);
            Book updatedBook = bookRepository.save(book);
            return bookMapper.toDto(updatedBook);
        }
        throw new RuntimeException("Book not found");
    }
    public void deleteBook(Long id, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can delete a book");
        }
        bookRepository.deleteById(id);
    }

}
