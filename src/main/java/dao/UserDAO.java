package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.UserModel;
import util.DatabaseUtil;

public class UserDAO {

    public void insertUser(UserModel user) {

        String sql = """
                INSERT INTO users (national_id, name, middle_name, last_name, sur_name, email, address, phone_number)
                VALUES (?, ?, ?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getNationalId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getMiddleName());
            ps.setString(4, user.getLastName());
            ps.setString(5, user.getSurName());
            ps.setString(6, user.getEmail());
            ps.setString(7, user.getAddress());
            ps.setLong(8, user.getPhoneNumber());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void updateUser(UserModel user) {
        String sql = """
                UPDATE users
                SET name = ?, middle_name = ?, last_name = ?, sur_name = ?, email = ?, address = ?, phone_number = ?
                WHERE national_id = ?
                """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getMiddleName());
            ps.setString(3, user.getLastName());
            ps.setString(4, user.getSurName());
            ps.setString(5, user.getEmail());
            ps.setString(6, user.getAddress());
            ps.setLong(7, user.getPhoneNumber());
            ps.setString(8, user.getNationalId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteUser(String nationalId) {
        String sql = "DELETE FROM users WHERE national_id = ?";

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nationalId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet searchUsers(String searchTerm, int page, int pageSize) {
        String sql = "SELECT * FROM users WHERE name LIKE ? OR national_id LIKE ? OR email LIKE ? LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseUtil.getLibraryConnection();
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