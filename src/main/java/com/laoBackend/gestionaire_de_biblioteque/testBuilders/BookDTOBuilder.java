package com.laoBackend.gestionaire_de_biblioteque.testBuilders;

import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookDTO;

public class BookDTOBuilder {
    private Long id = 1L;
    private String title = "The House";
    private String author = "Johnyy Hu";
    private String publisher = "Bronzed";
    private int yearPublished = 2018;
    private String genre = "Documentary";
    private String description = "How are house built";
    private int availableCopies = 5;

    public BookDTOBuilder withId(Long id){
        this.id= id;
        return this;
    }

    public BookDTOBuilder withTitle(String title){
        this.title= title;
        return this;
    }

    public BookDTOBuilder withAuthor(String author){
        this.author= author;
        return this;
    }
    public BookDTOBuilder withPublisher(String publisher){
        this.publisher= publisher;
        return this;
    }
    public BookDTOBuilder withYearPublished(int yearPublished){
        this.yearPublished= yearPublished;
        return this;
    }
    public BookDTOBuilder withGenre(String genre){
        this.genre= genre;
        return this;
    }
    public BookDTOBuilder withDescription(String description){
        this.description= description;
        return this;
    }
    public BookDTOBuilder withAvailableCopies(int availableCopies){
        this.availableCopies= availableCopies;
        return this;
    }

    public BookDTO build(){
        return new BookDTO(id,title,author,publisher,yearPublished,genre,description,availableCopies);
    }
}
