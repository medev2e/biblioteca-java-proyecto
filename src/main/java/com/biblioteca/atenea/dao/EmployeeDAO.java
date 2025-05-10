package com.biblioteca.atenea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.biblioteca.atenea.model.EmployeeModel;
import com.biblioteca.atenea.util.DatabaseUtil;
import com.biblioteca.atenea.util.SecurityUtil;

public class EmployeeDAO {
    public void insertEmployee(EmployeeModel employee) {

        String sql = """
                INSERT INTO employees (system_id, name, middle_name, last_name, sur_name, username, password)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getSystemId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getMiddleName());
            ps.setString(4, employee.getLastName());
            ps.setString(5, employee.getSurName());
            ps.setString(6, employee.getUsername());
            ps.setString(7, employee.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void verifyEmployee(String username, String password) {
        String sql = "SELECT * FROM employees WHERE username = ?";

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    String hashedPassword = rs.getString("password");

                    if (SecurityUtil.verifyPassword(password, hashedPassword)) {
                        System.out.println("Login exitoso");
                    } else {
                        System.out.println("Contraseña incorrecta");
                    }
                } else {
                    System.out.println("Usuario no encontrado");
                }
            }
        } catch (Exception e) {
        }
    }

    public void updateEmployee(EmployeeModel employee) {
        String sql = """
                UPDATE employees
                SET name = ?, middle_name = ?, last_name = ?, sur_name = ?, username = ?, password = ?
                WHERE system_id = ?
                """;
        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getMiddleName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getSurName());
            ps.setString(5, employee.getUsername());
            ps.setString(6, employee.getPassword());
            ps.setString(7, employee.getSystemId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteEmployee(String systemId) {
        String sql = "DELETE FROM employees WHERE system_id = ?";
        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, systemId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
