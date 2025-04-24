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
    private final BookRepository bookRepository;
    private final BookCreationMapper bookCreationMapper;
    private final BookMapper bookMapper;

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
                bookCreationDTO.getTitle(),
                bookCreationDTO.getAuthor(),
                bookCreationDTO.getPublisher())) {
            throw new IllegalStateException("Book already exists");
        }
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can add a book");
        }
        Book book = bookCreationMapper.toEntity(bookCreationDTO);
        book.setCreatedOn(LocalDateTime.now());
        bookRepository.save(book);
        return bookMapper.toDto(book);
    }
    public List<BookDTO> getAllBooks() {
        return  bookRepository.findAll().stream().map(bookMapper::toDto).toList();
    }
    public BookDTO getBookById(Long id, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can get the book by ID");
        }
        return bookRepository.findById(id)
                .map(bookMapper::toDto)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }
    public List<BookDTO> getBooksByTitle(String title) {
        return bookMapper.toDto(bookRepository.findByTitle(title));
    }
    public List<BookDTO> getBooksByAuthor(String author) {
        return bookMapper.toDto(bookRepository.findByAuthor(author));
    }
    public List<BookDTO> getBooksByGenre(String genre) {
        return bookMapper.toDto(bookRepository.findByGenre(genre));
    }
    public List<BookDTO> getBooksByPublisher(String publisher) {
        return bookMapper.toDto(bookRepository.findByPublisher(publisher));
    }
    public void updateBook(Long id, BookCreationDTO bookCreationDTO, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new ResourceNotFoundException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can add a book");
        }
        if (bookRepository.existsById(id)) {
            Book book = bookCreationMapper.toEntity(bookCreationDTO);
            book.setId(id);
            bookRepository.save(book);
        } else {
            throw new ResourceNotFoundException("Book not found");
        }
    }
    public void deleteBook(Long id, Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new RuntimeException("User doesn't exist"));
        if(!member.getRole().toString().equalsIgnoreCase("LIBRARIAN")){
            throw new RuntimeException("Only librarian can delete a book");
        }
        bookRepository.deleteById(id);
    }

}
