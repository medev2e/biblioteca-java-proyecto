package com.biblioteca.atenea.config;

import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.nio.file.Files;

public class DatabaseConfig {
    private static final String DB_DIRECTORY = "var/db/";
    private static final String USERS_DB = buildRoute("users.db");
    private static final String EMPLOYEES_DB = buildRoute("employees.db");
    private static final String BOOKS_DB = buildRoute("books.db");

    private static String buildRoute(String fileName) {
        return DB_DIRECTORY + fileName;
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

    public static Connection getUsersConnection() throws SQLException {
        checkRouteExist();
        return DriverManager.getConnection("jdbc:sqlite:" + USERS_DB);
    }

    public static Connection getEmployeesConnection() throws SQLException {
        checkRouteExist();
        return DriverManager.getConnection("jdbc:sqlite:" + EMPLOYEES_DB);
    }

    public static Connection getBooksConnection() throws SQLException {
        checkRouteExist();
        return DriverManager.getConnection("jdbc:sqlite:" + BOOKS_DB);
    }
}
