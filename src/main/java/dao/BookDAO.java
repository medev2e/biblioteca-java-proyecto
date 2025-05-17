package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.base.BookModel;
import util.DatabaseUtil;

public class BookDAO {

    public void insertBook(BookModel book) {

        String sql = """
                INSERT INTO books (isbn_number, title, author, publisher, genre, edition, available)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getIsbnNumber());
            ps.setString(2, book.getTitle());
            ps.setString(3, book.getAuthor());
            ps.setString(4, book.getPublisher());
            ps.setString(5, book.getGenre());
            ps.setString(6, book.getEdition());
            ps.setInt(7, book.getAvailable() ? 1 : 0);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet searchBooksByTitle(String title, int page, int pageSize) {
        String sql = "SELECT * FROM books WHERE title LIKE ? LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseUtil.getLibraryConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + title + "%");
            ps.setInt(2, pageSize);
            ps.setInt(3, (page - 1) * pageSize);

            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public void updateBook(BookModel book) {
        String sql = """
                UPDATE books
                SET title = ?, author = ?, publisher = ?, genre = ?, edition = ?, available = ?
                WHERE isbn_number = ?
                """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, book.getTitle());
            ps.setString(2, book.getAuthor());
            ps.setString(3, book.getPublisher());
            ps.setString(4, book.getGenre());
            ps.setString(5, book.getEdition());
            ps.setInt(6, book.getAvailable() ? 1 : 0);
            ps.setString(7, book.getIsbnNumber());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteBook(String bookId) {
        String sql = "DELETE FROM books WHERE book_id = ?";

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bookId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet allBooks(int page, int pageSize) {
        String sql = "SELECT * FROM books LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseUtil.getLibraryConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
}
