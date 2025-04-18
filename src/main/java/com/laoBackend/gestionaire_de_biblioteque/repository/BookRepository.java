package com.laoBackend.gestionaire_de_biblioteque.repository;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    List<Book> findByPublisher(String publisher);

    List<Book> findByGenre(String genre);

    List<Book> findByAuthor(String author);

    boolean existsByTitleAndAuthorAndPublisher(String bookTitle, String bookAuthor, String publisher);

    List<Book> findByTitle(String title);
}
