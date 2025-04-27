package com.biblioteca.atenea.config;

import java.nio.file.Path;
import java.nio.file.Files;

public class DatabaseConfig {
    private static final String DB_DIRECTORY = "var/db/";
    private static final String[] DB_ROUTE = { buildRoute("users.db"), buildRoute("employees.db"),
            buildRoute("books.db") };

    private static String buildRoute(String fileName) {
        return DB_DIRECTORY + fileName;
    }

    private static void checkRouteExist() {
        try {

            Path dbDirectoryPath = Path.of(DB_DIRECTORY);

            if (Files.notExists(dbDirectoryPath)) {
                Files.createDirectories(dbDirectoryPath);
            }

            for (int i = 0; i < DB_ROUTE.length; i++) {

                Path dbFilesPath = Path.of(DB_ROUTE[i]);

                if (Files.notExists(dbFilesPath)) {
                    Files.createFile(dbFilesPath);
                }
            }
        } catch (Exception e) {

        }
    }

}
