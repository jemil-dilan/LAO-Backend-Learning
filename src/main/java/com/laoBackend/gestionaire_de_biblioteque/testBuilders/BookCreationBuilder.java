package com.laoBackend.gestionaire_de_biblioteque.testBuilders;


import com.laoBackend.gestionaire_de_biblioteque.dto.book.BookCreationDTO;

public class BookCreationBuilder {
    private String title = "The House";
    private String author = "Johnyy Hu";
    private String publisher = "Bronzed";
    private int yearPublished = 2018;
    private String genre = "Documentary";
    private String description = "How are house built";
    private int availableCopies = 5;
    private  int totalCopies = 10;

    public BookCreationBuilder withTitle(String title){
        this.title= title;
        return this;
    }

    public BookCreationBuilder withAuthor(String author){
        this.author= author;
        return this;
    }
    public BookCreationBuilder withPublisher(String publisher){
        this.publisher= publisher;
        return this;
    }
    public BookCreationBuilder withYearPublished(int yearPublished){
        this.yearPublished= yearPublished;
        return this;
    }
    public BookCreationBuilder withGenre(String genre){
        this.genre= genre;
        return this;
    }
    public BookCreationBuilder withDescription(String description){
        this.description= description;
        return this;
    }
    public BookCreationBuilder withAvailableCopies(int availableCopies){
        this.availableCopies= availableCopies;
        return this;
    }

    public BookCreationBuilder withTotalCopies(int totalCopies){
        this.totalCopies= totalCopies;
        return this;
    }

    public BookCreationDTO build(){
        return new BookCreationDTO(title,author,publisher,yearPublished,genre,description,availableCopies,totalCopies);
    }
}
