package com.biblioteca.atenea.config;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import java.nio.file.Files;

public class DatabaseConfig {
    private static final String DB_DIRECTORY = "var/db/";
    private static final String LIBRARY_DB = DB_DIRECTORY + "library_management.db";

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

    public static Connection getLibraryConnection() throws SQLException {
        checkRouteExist();
        checkDatabaseExist();
        return DriverManager.getConnection("jdbc:sqlite:" + LIBRARY_DB);
    }

    private static void createTable(String sql) {
        try (Connection conn = getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.execute();
        } catch (Exception e) {
        }
    }

    private static void createUsersTable() {
        String sql = """
                    CREATE TABLE IF NOT EXISTS users (
                        system_id TEXT PRIMARY KEY,
                        name TEXT NOT NULL,
                        middle_name TEXT,
                        last_name TEXT NOT NULL,
                        national_id TEXT UNIQUE NOT NULL,
                        email TEXT UNIQUE NOT NULL,
                        address TEXT NOT NULL,
                        phone_number INTEGER UNIQUE NOT NULL
                    );
                """;
        createTable(sql);
    }

    private static void createEmployeesTable() {
        String sql = """
                    CREATE TABLE IF NOT EXISTS employees (
                        system_id TEXT PRIMARY KEY,
                        name TEXT NOT NULL,
                        middle_name TEXT,
                        last_name TEXT NOT NULL,
                        username TEXT NOT NULL,
                        password TEXT NOT NULL
                    );
                """;
        createTable(sql);
    }

    private static void createBooksTable() {
        String sql = """
                    CREATE TABLE IF NOT EXISTS books (
                        system_id TEXT PRIMARY KEY,
                        title TEXT NOT NULL,
                        author TEXT NOT NULL,
                        publisher TEXT,
                        publication_year TEXT,
                        genre TEXT,
                        isbn_number TEXT UNIQUE NOT NULL,
                        edition TEXT,
                        available NUMERIC NOT NULL
                    );
                """;
        createTable(sql);
    }

    private static void createPenaltiesTable() {
        String sql = """
                    CREATE TABLE IF NOT EXISTS penalties (
                        user_id TEXT NOT NULL,
                        start_date TEXT NOT NULL,
                        end_date TEXT NOT NULL,
                        reason TEXT NOT NULL,
                        additional_note TEXT,
                        FOREIGN KEY (user_id) REFERENCES users(system_id)
                    );
                """;
        createTable(sql);
    }

    public static void createLibraryTable() {
        createBooksTable();
        createEmployeesTable();
        createPenaltiesTable();
        createUsersTable();
    }
}
