package com.biblioteca.atenea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.biblioteca.atenea.config.DatabaseConfig;
import com.biblioteca.atenea.models.UserModel;

public class UserDAO {

    public void createUser(UserModel user) {

        String sql = """
                INSERT INTO users (system_id, name, middle_name, last_name, national_id, email, address, phone_number)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getSystemId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getMiddleName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getNationalId());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getAddress());
            ps.setLong(8, user.getPhoneNumber());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public List<UserModel> getUsersByName(String name) {
        String sql = "SELECT * FROM users WHERE name LIKE ?";
        List<UserModel> users = new ArrayList<>();

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    UserModel user = new UserModel(
                            rs.getString("system_id"),
                            rs.getString("name"),
                            rs.getString("middle_name"),
                            rs.getString("last_name"),
                            rs.getString("national_id"),
                            rs.getString("email"),
                            rs.getString("address"),
                            rs.getLong("phone_number"));
                    users.add(user);
                }
            }
        } catch (Exception e) {
        }

        return users;
    }

    public void updateUser(UserModel user) {
        String sql = """
                UPDATE users
                SET name = ?, middle_name = ?, last_name = ?, national_id = ?, email = ?, address = ?, phone_number = ?
                WHERE system_id = ?
                """;
        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getMiddleName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getNationalId());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getAddress());
            ps.setLong(7, user.getPhoneNumber());
            ps.setString(8, user.getSystemId());
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

    public List<UserModel> getAllUser() {
        String sql = "SELECT * FROM users";
        List<UserModel> users = new ArrayList<>();

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UserModel user = new UserModel(
                        rs.getString("system_id"),
                        rs.getString("name"),
                        rs.getString("middle_name"),
                        rs.getString("last_name"),
                        rs.getString("national_id"),
                        rs.getString("email"),
                        rs.getString("address"),
                        rs.getLong("phone_number"));
                users.add(user);
            }
        } catch (Exception e) {
        }

        return users;
    }
}