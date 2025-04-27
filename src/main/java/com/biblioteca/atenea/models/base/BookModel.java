package com.biblioteca.atenea.models.base;

public class BookModel {

    private String systemId;
    private String title;
    private String author;
    private String publisher;
    private String publicationYear;
    private String genre;
    private String isbnNumber;
    private String edition;
    private boolean available;

    public BookModel() {
    }

    public BookModel(String systemId, String title, String author, String publisher, String publicationYear,
            String genre,
            String isbnNumber,
            String edition, boolean available) {
        this.systemId = systemId;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
        this.publicationYear = publicationYear;
        this.genre = genre;
        this.isbnNumber = isbnNumber;
        this.edition = edition;
        this.available = available;
    }

    public BookModel(String systemId, String title, String author, String publisher, String publicationYear,
            String genre,
            String isbnNumber,
            String edition) {
        this(systemId, title, author, publisher, publicationYear, genre, isbnNumber, edition, true);
    }

    public String getSystemId() {
        return systemId;
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

    public boolean getAvailable() {
        return this.available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }

}
