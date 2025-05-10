package com.biblioteca.atenea.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.biblioteca.atenea.model.base.PenaltyModel;
import com.biblioteca.atenea.util.DatabaseUtil;

public class PenaltyDAO {

    public void insertPenalty(PenaltyModel penalty) {
        String sql = """
                INSERT INTO penalties (national_id, start_date, end_date, reason, additional_notes, penalty_amount, is_paid)
                VALUES (?, ?, ?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, penalty.getNationalId());
            ps.setDate(2, Date.valueOf(penalty.getStartDate()));
            ps.setDate(3, Date.valueOf(penalty.getEndDate()));
            ps.setString(4, penalty.getReason());
            ps.setString(5, penalty.getAdditionalNotes());
            ps.setDouble(6, penalty.getPenaltyAmount());
            ps.setInt(7, penalty.getIsPaid() ? 1 : 0);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet searchPenaltiesByUser(String nationalId, int page, int pageSize) {
        String sql = "SELECT * FROM penalties WHERE national_id = ? LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseUtil.getLibraryConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, nationalId);
            ps.setInt(2, pageSize);
            ps.setInt(3, (page - 1) * pageSize);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public void updatePenalty(int penaltyId, PenaltyModel penalty) {
        String sql = """
                UPDATE penalties
                SET national_id = ?, start_date = ?, end_date = ?, reason = ?, additional_notes = ?, penalty_amount = ?, is_paid = ?
                WHERE penalty_id = ?
                """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, penalty.getNationalId());
            ps.setDate(1, Date.valueOf(penalty.getStartDate()));
            ps.setDate(2, Date.valueOf(penalty.getEndDate()));
            ps.setString(3, penalty.getReason());
            ps.setString(4, penalty.getAdditionalNotes());
            ps.setDouble(5, penalty.getPenaltyAmount());
            ps.setInt(6, penalty.getIsPaid() ? 1 : 0);
            ps.setInt(7, penaltyId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deletePenalty(int penaltyId) {
        String sql = "DELETE FROM penalties WHERE penalty_id = ?";

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, penaltyId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet searchPenalties(int page, int pageSize) {
        String sql = "SELECT * FROM penalties LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseUtil.getLibraryConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, pageSize);
            ps.setInt(2, (page - 1) * pageSize);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }
}
