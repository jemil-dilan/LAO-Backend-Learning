package com.laoBackend.gestionaire_de_biblioteque.controller;

import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookCreationDTO;
import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookDTO;
import com.laoBackend.gestionaire_de_biblioteque.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/books")
public class BookController {
    BookService bookService;
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookDTO>> getAllBooks(){
        return ResponseEntity.ok(bookService.getAllBooks());
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookCreationDTO bookCreationDTO, @RequestParam Long memberId){
        return ResponseEntity.status(HttpStatus.CREATED).body(bookService.createBook(bookCreationDTO, memberId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id, @RequestParam Long memberId){
        return ResponseEntity.ok(bookService.getBookById(id, memberId));
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDTO>> getBooksByTitle(@PathVariable String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable String author){
        return ResponseEntity.ok(bookService.getBooksByAuthor(author));
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<BookDTO>> getBooksByGenre(@PathVariable String genre){
        return ResponseEntity.ok(bookService.getBooksByGenre(genre));
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<BookDTO>> getBooksByPublisher(@PathVariable String publisher){
        return ResponseEntity.ok(bookService.getBooksByPublisher(publisher));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateBook(@PathVariable Long id, @RequestBody BookCreationDTO bookCreationDTO, @RequestParam Long memberId){
        bookService.updateBook(id, bookCreationDTO, memberId);
        return  ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id, @RequestParam Long memberId){
        bookService.deleteBook(id,memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
