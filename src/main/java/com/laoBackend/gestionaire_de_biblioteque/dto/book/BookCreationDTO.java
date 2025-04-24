package com.laoBackend.gestionaire_de_biblioteque.dto.book;



public class BookCreationDTO {
    private String title;
    private String author;
    private String publisher;
    private int yearPublished;
    private String genre;
    private String description;
    private int availableCopies;
    private int totalCopies;

    public BookCreationDTO(String title, String author, String publisher, int yearPublished, String genre, String description, int availableCopies, int totalCopies) {
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.yearPublished = yearPublished;
        this.genre = genre;
        this.description = description;
        this.availableCopies = availableCopies;
        this.totalCopies = totalCopies;
    }

    public BookCreationDTO() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public int getYearPublished() {
        return yearPublished;
    }

    public void setYearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    public int getTotalCopies() {
        return totalCopies;
    }

    public void setTotalCopies(int totalCopies) {
        this.totalCopies = totalCopies;
    }
}
