package util;

import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DatabaseUtil {

    private static final String DB_DIRECTORY = "data/";
    private static final String LIBRARY_DB = DB_DIRECTORY + "library_management.db";

    public static Connection getLibraryConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:sqlite:" + LIBRARY_DB);
    }

    private static void checkRouteExist() {
        try {

            Path dbDirectoryPath = Path.of(DB_DIRECTORY);

            if (Files.notExists(dbDirectoryPath)) {
                Files.createDirectories(dbDirectoryPath);
            }
        } catch (Exception e) {

        }
    }

    private static void checkDatabaseExist() {
        try {

            Path dbFilePath = Path.of(LIBRARY_DB);

            if (Files.notExists(dbFilePath)) {
                Files.createFile(dbFilePath);
            }
        } catch (Exception e) {

        }
    }

    public static void initializeDatabase() {

        checkRouteExist();
        checkDatabaseExist();

        String createTables = """
                CREATE TABLE IF NOT EXISTS users (
                        user_id INTEGER PRIMARY KEY AUTOINCREMENT,
                        national_id TEXT UNIQUE NOT NULL,
                        name TEXT NOT NULL,
                        middle_name TEXT,
                        last_name TEXT NOT NULL,
                        sur_name TEXT NOT NULL,
                        email TEXT UNIQUE NOT NULL,
                        address TEXT NOT NULL,
                        phone_number INTEGER UNIQUE NOT NULL
                    );

                CREATE TABLE IF NOT EXISTS employees (
                        employe_id INTEGER PRIMARY KEY AUTOINCREMENT,
                        username TEXT UNIQUE NOT NULL,
                        name TEXT NOT NULL,
                        middle_name TEXT,
                        last_name TEXT NOT NULL,
                        sur_name TEXT NOT NULL,
                        password TEXT NOT NULL
                    );

                CREATE TABLE IF NOT EXISTS books (
                        book_id INTEGER PRIMARY KEY AUTOINCREMENT,
                        isbn_number TEXT NOT NULL,
                        title TEXT NOT NULL,
                        author TEXT NOT NULL,
                        publisher TEXT,
                        genre TEXT,
                        edition TEXT,
                        available NUMERIC NOT NULL
                    );

                CREATE TABLE IF NOT EXISTS loans (
                        loan_id INTEGER PRIMARY KEY AUTOINCREMENT,
                        national_id TEXT NOT NULL,
                        isbn_number TEXT NOT NULL,
                        loan_date TEXT NOT NULL,
                        return_date TEXT NOT NULL,
                        FOREIGN KEY (national_id) REFERENCES users(national_id),
                        FOREIGN KEY (isbn_number) REFERENCES books(isbn_number)
                    );

                CREATE TABLE IF NOT EXISTS penalties (
                        penalty_id INTEGER PRIMARY KEY AUTOINCREMENT,
                        national_id TEXT NOT NULL,
                        reason TEXT NOT NULL,
                        additional_note TEXT,
                        penalty_amount NUMERIC NOT NULL,
                        is_paid NUMERIC NOT NULL,
                        FOREIGN KEY (national_id) REFERENCES users(national_id)
                    );
                """;

        try (Connection conn = getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(createTables)) {
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
