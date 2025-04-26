package com.biblioteca.atenea.models;

import java.util.UUID;

public class Book {

    private final String id;
    private String title;
    private String author;
    private String publisher;
    private String publicationYear;
    private String genre;
    private String isbnNumber;
    private String edition;

    public Book() {
        this.id = UUID.randomUUID().toString();
    }

    public Book(String title, String author, String publisher, String publicationYear, String genre, String isbnNumber,
            String edition) {
        this.id = UUID.randomUUID().toString();
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.isbnNumber = isbnNumber;
        this.edition = edition;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return this.author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getPublisher() {
        return this.publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublicationYear() {
        return this.publicationYear;
    }

    public void setPublicationYear(String publicationYear) {
        this.publicationYear = publicationYear;
    }

    public String getGenre() {
        return this.genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getIsbnNumber() {
        return this.isbnNumber;
    }

    public void setIsbnNumber(String isbnNumber) {
        this.isbnNumber = isbnNumber;
    }

    public String getEdition() {
        return this.edition;
    }

    public void setEdition(String edition) {
        this.edition = edition;
    }

}
