package com.biblioteca.atenea.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatabaseConfig {
    public static final String DB_DIRECTORY = "var/db";
    public static final String DB_BOOKS = "books.db";
    public static final String DB_USERS = "users.db";
    public static final String DB_LIBRARIANS = "librarians.db";
    public static final String DB_ADMINS = "admins.db";

    private static final String BOOKS_URL = "jdbc:sqlite:" + DB_DIRECTORY + "/" + DB_BOOKS;
    private static final String USERS_URL = "jdbc:sqlite:" + DB_DIRECTORY + "/" + DB_USERS;
    private static final String LIBRARIANS_URL = "jdbc:sqlite:" + DB_DIRECTORY + "/" + DB_LIBRARIANS;
    private static final String ADMINS_URL = "jdbc:sqlite:" + DB_DIRECTORY + "/" + DB_ADMINS;

    private static void createDatabaseDirectory() {
        try {
            Path dbDir = Paths.get(DB_DIRECTORY);
            if (!Files.exists(dbDir)) {
                Files.createDirectories(dbDir);
            }
        } catch (Exception error) {
            throw new RuntimeException("Error al crear directorio de bases de datos", error);
        }
    }

    public static Connection getBooksConnection() throws SQLException {
        createDatabaseDirectory();
        return DriverManager.getConnection(BOOKS_URL);
    }

    public static Connection getUsersConnection() throws SQLException {
        createDatabaseDirectory();
        return DriverManager.getConnection(USERS_URL);
    }

    public static Connection getAdminsConnection() throws SQLException {
        createDatabaseDirectory();
        return DriverManager.getConnection(ADMINS_URL);
    }

    public static Connection getLibrariansConnection() throws SQLException {
        createDatabaseDirectory();
        return DriverManager.getConnection(LIBRARIANS_URL);
    }

    private static void initBooksDatabase() {
        String createBooksTable = """
                    CREATE TABLE IF NOT EXISTS books (
                        id TEXT PRIMARY KEY,
                        title TEXT NOT NULL,
                        author TEXT NOT NULL,
                        publisher TEXT,
                        publication_year TEXT,
                        genre TEXT,
                        isbn_number TEXT UNIQUE NOT NULL,
                        edition TEXT
                    );
                """;

        try (Connection conn = getBooksConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(createBooksTable);
            System.out.println("Base [Libros] inicializa correctamente");
        } catch (SQLException error) {
            System.err.println("Error al inicializar base [Libros]: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }

    private static void initUsersDatabase() {
        String createUsersTable = """
                    CREATE TABLE IF NOT EXISTS users (
                        id TEXT PRIMARY KEY,
                        name TEXT NOT NULL,
                        middle_name TEXT,
                        last_name TEXT NOT NULL,
                        id_number TEXT UNIQUE NOT NULL,
                        email TEXT UNIQUE NOT NULL,
                        address TEXT,
                        phone_number INTEGER
                    );
                """;

        try (Connection conn = getUsersConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(createUsersTable);
            System.out.println("Base [Usuarios] inicializa correctamente");
        } catch (SQLException error) {
            System.err.println("Error al inicializar base [Usuarios]: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }

    private static void initAdminsDatabase() {
        String createAdminsTable = """
                    CREATE TABLE IF NOT EXISTS users (
                        id TEXT PRIMARY KEY,
                        admin_user TEXT UNIQUE NOT NULL
                        hashed_password TEXT NOT NULL
                    );
                """;

        try (Connection conn = getAdminsConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(createAdminsTable);
            System.out.println("Base [Admins] inicializa correctamente");
        } catch (SQLException error) {
            System.err.println("Error al inicializar base [Admins]: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }

    private static void initLibrariansDatabase() {
        String createAdminsTable = """
                    CREATE TABLE IF NOT EXISTS users (
                        id TEXT PRIMARY KEY,
                        librarian_user TEXT UNIQUE NOT NULL
                        hashed_password TEXT NOT NULL
                    );
                """;

        try (Connection conn = getLibrariansConnection();
                Statement stmt = conn.createStatement()) {
            stmt.execute(createAdminsTable);
            System.out.println("Base [Encargados] inicializa correctamente");
        } catch (SQLException error) {
            System.err.println("Error al inicializar base [Encargados]: " + error.getMessage());
            throw new RuntimeException(error);
        }
    }

    public static void initDatabases() {
        initBooksDatabase();
        initUsersDatabase();
        initAdminsDatabase();
        initLibrariansDatabase();
    }

}