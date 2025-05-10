package com.biblioteca.atenea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.biblioteca.atenea.config.DatabaseConfig;
import com.biblioteca.atenea.models.UserModel;

public class UserDAO {

    public void insertUser(UserModel user) {

        String sql = """
                INSERT INTO users (system_id, name, middle_name, last_name, sur_name, national_id, email, address, phone_number)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getSystemId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getMiddleName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getSurName());
            ps.setString(6, user.getNationalId());
            ps.setString(7, user.getEmail());
            ps.setString(8, user.getAddress());
            ps.setLong(9, user.getPhoneNumber());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet searchUsersByName(String name, int page, int pageSize) {
        String sql = "SELECT * FROM users WHERE name LIKE ? LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseConfig.getLibraryConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + name + "%");
            ps.setInt(2, pageSize);
            ps.setInt(3, (page - 1) * pageSize);

            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public void updateUser(UserModel user) {
        String sql = """
                UPDATE users
                SET name = ?, middle_name = ?, last_name = ?, sur_name = ?, national_id = ?, email = ?, address = ?, phone_number = ?
                WHERE system_id = ?
                """;
        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getMiddleName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getSurName());
            ps.setString(5, user.getNationalId());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getAddress());
            ps.setLong(8, user.getPhoneNumber());
            ps.setString(9, user.getSystemId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteUser(String systemId) {
        String sql = "DELETE FROM users WHERE system_id = ?";
        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, systemId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet searchUsers(String searchTerm, int page, int pageSize) {
        String sql = "SELECT * FROM users WHERE name LIKE ? OR national_id LIKE ? OR email LIKE ? LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseConfig.getLibraryConnection();
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, "%" + searchTerm + "%");
            ps.setString(2, "%" + searchTerm + "%");
            ps.setString(3, "%" + searchTerm + "%");
            ps.setInt(4, pageSize);
            ps.setInt(5, (page - 1) * pageSize);

            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
}