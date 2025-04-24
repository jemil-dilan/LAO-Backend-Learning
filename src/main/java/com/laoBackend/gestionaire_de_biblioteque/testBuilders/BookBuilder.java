package com.laoBackend.gestionaire_de_biblioteque.testBuilders;

import com.laoBackend.gestionaire_de_biblioteque.domain.Book;

import java.time.LocalDateTime;

public class BookBuilder {
    private Long id = 1L;
    private String title = "The House";
    private String author = "Johnyy Hu";
    private String publisher = "Bronzed";
    private int yearPublished = 2018;
    private String genre = "Documentary";
    private String description = "How are house built";
    private int availableCopies = 5;
    private int totalCopies = 8;
    private LocalDateTime createdOn = LocalDateTime.of(2025,1,25,3,15);
    private LocalDateTime updatedOn = null;

    public BookBuilder withId(Long id){
        this.id= id;
        return this;
    }

    public BookBuilder withTitle(String title){
        this.title= title;
        return this;
    }

    public BookBuilder withAuthor(String author){
        this.author= author;
        return this;
    }
    public BookBuilder withPublisher(String publisher){
        this.publisher= publisher;
        return this;
    }
    public BookBuilder withYearPublished(int yearPublished){
        this.yearPublished= yearPublished;
        return this;
    }
    public BookBuilder withGenre(String genre){
        this.genre= genre;
        return this;
    }
    public BookBuilder withDescription(String description){
        this.description= description;
        return this;
    }
    public BookBuilder withAvailableCopies(int availableCopies){
        this.availableCopies= availableCopies;
        return this;
    }
    public BookBuilder withTotalCopies(int totalCopies){
        this.totalCopies= totalCopies;
        return this;
    }
    public BookBuilder withCreationDate(LocalDateTime creationDate){
        this.createdOn= creationDate;
        return this;
    }
    public BookBuilder withUpdatedDate(LocalDateTime updatedDated){
        this.updatedOn= updatedDated;
        return this;
    }

    public Book build(){
        return new Book(id,title,author,publisher,yearPublished,genre,description,availableCopies,totalCopies,createdOn, updatedOn);
    }

}
