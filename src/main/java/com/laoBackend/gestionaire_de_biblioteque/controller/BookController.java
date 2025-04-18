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
        List<BookDTO> allBooks = bookService.getAllBooks();
        return allBooks.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(allBooks);
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook(@RequestBody BookCreationDTO bookCreationDTO, @RequestParam Long memberId){
        BookDTO createdBook = bookService.createBook(bookCreationDTO, memberId);
        return createdBook == null ?
                ResponseEntity.status(HttpStatus.BAD_REQUEST).build() :
                ResponseEntity.status(HttpStatus.CREATED).body(createdBook);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBookById(@PathVariable Long id, @RequestParam Long memberId){
        BookDTO book = bookService.getBookById(id, memberId);
        return book == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(book);
    }

    @GetMapping("/title/{title}")
    public ResponseEntity<List<BookDTO>> getBooksByTitle(@PathVariable String title){
        List<BookDTO> booksByTitle = bookService.getBooksByTitle(title);
        return booksByTitle.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(booksByTitle);
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookDTO>> getBooksByAuthor(@PathVariable String author){
        List<BookDTO> booksByAuthor = bookService.getBooksByAuthor(author);
        return booksByAuthor.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(booksByAuthor);
    }

    @GetMapping("/genre/{genre}")
    public ResponseEntity<List<BookDTO>> getBooksByGenre(@PathVariable String genre){
        List<BookDTO> booksByGenre = bookService.getBooksByGenre(genre);
        return booksByGenre.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(booksByGenre);
    }

    @GetMapping("/publisher/{publisher}")
    public ResponseEntity<List<BookDTO>> getBooksByPublisher(@PathVariable String publisher){
        List<BookDTO> booksByPublisher = bookService.getBooksByPublisher(publisher);
        return booksByPublisher.isEmpty() ?
                ResponseEntity.status(HttpStatus.NO_CONTENT).build() :
                ResponseEntity.ok(booksByPublisher);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable Long id, @RequestBody BookCreationDTO bookCreationDTO, @RequestParam Long memberId){
        BookDTO updatedBook = bookService.updateBook(id, bookCreationDTO, memberId);
        return updatedBook == null ?
                ResponseEntity.status(HttpStatus.NOT_FOUND).build() :
                ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id, @RequestParam Long memberId){
        bookService.deleteBook(id,memberId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
