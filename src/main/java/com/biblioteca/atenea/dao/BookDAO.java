package com.biblioteca.atenea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.atenea.config.DatabaseConfig;
import com.biblioteca.atenea.models.base.BookModel;

public class BookDAO {

    public void insertBook(BookModel book) {

        String sql = """
                INSERT INTO books (title, author, publisher, publication_year, genre, isbn_number, edition, available)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setString(4, book.getPublicationYear());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getIsbnNumber());
            ps.setString(7, book.getEdition());
            ps.setInt(8, book.getAvailable() ? 1 : 0);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<BookModel> searchBooksByTitle(String title) {
        List<BookModel> books = new ArrayList<>();
        String sql = "SELECT * FROM books WHERE title LIKE ?";

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, "%" + title + "%");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                BookModel book = new BookModel(
                        rs.getString("isbn_number"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getString("publication_year"),
                        rs.getString("genre"),
                        rs.getString("edition"),
                        rs.getInt("available") == 1 ? true : false);
                books.add(book);
            }
        } catch (Exception e) {
        }
        return books;
    }

    public void updateBook(BookModel book) {
        String sql = """
                UPDATE books
                SET title = ?, author = ?, publisher = ?, publication_year = ?,
                genre = ?, edition = ?, available = ?
                WHERE isbn_number = ?
                """;

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setString(4, book.getPublicationYear());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getEdition());
            ps.setInt(7, book.getAvailable() ? 1 : 0);
            ps.setString(8, book.getIsbnNumber());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteBook(String isbnNumber) {
        String sql = "DELETE FROM books WHERE isbn_number = ?";

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, isbnNumber);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<BookModel> getAllBooks() {
        List<BookModel> books = new ArrayList<>();
        String sql = "SELECT * FROM books";

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                BookModel book = new BookModel(
                        rs.getString("isbn_number"),
                        rs.getString("title"),
                        rs.getString("author"),
                        rs.getString("publisher"),
                        rs.getString("publication_year"),
                        rs.getString("genre"),
                        rs.getString("edition"),
                        rs.getInt("available") == 1 ? true : false);
                books.add(book);
            }
        } catch (Exception e) {
        }
        return books;
    }
}
