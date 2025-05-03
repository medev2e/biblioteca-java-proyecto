package com.biblioteca.atenea.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.biblioteca.atenea.config.DatabaseConfig;
import com.biblioteca.atenea.models.EmployeeModel;

public class EmployeeDAO {
    public void insertEmployee(EmployeeModel employee) {

        String sql = """
                INSERT INTO employees (system_id, name, middle_name, last_name, username, password)
                VALUES (?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getSystemId());
            ps.setString(2, employee.getName());
            ps.setString(3, employee.getMiddleName());
            ps.setString(4, employee.getLastName());
            ps.setString(5, employee.getUsername());
            ps.setString(6, employee.getPassword());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public EmployeeModel searchEmployeeByUsername(String username) {
        String sql = "SELECT * FROM employees WHERE username = ?";
        EmployeeModel employee = new EmployeeModel();

        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, username);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    employee = new EmployeeModel(
                            rs.getString("system_id"),
                            rs.getString("name"),
                            rs.getString("middle_name"),
                            rs.getString("last_name"),
                            rs.getString("username"),
                            rs.getString("password"));
                }
            }
        } catch (Exception e) {
        }

        return employee;
    }

    public void updateEmployee(EmployeeModel employee) {
        String sql = """
                UPDATE employees
                SET name = ?, middle_name = ?, last_name = ?, username = ?, password = ?
                WHERE system_id = ?
                """;
        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, employee.getName());
            ps.setString(2, employee.getMiddleName());
            ps.setString(3, employee.getLastName());
            ps.setString(4, employee.getUsername());
            ps.setString(5, employee.getPassword());
            ps.setString(8, employee.getSystemId());
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteEmployee(String systemId) {
        String sql = "DELETE FROM employees WHERE system_id = ?";
        try (Connection conn = DatabaseConfig.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, systemId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }
}
