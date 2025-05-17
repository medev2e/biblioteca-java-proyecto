package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.base.PenaltyModel;
import util.DatabaseUtil;

public class PenaltyDAO {

    public void insertPenalty(PenaltyModel penalty) {
        String sql = """
                INSERT INTO penalties (national_id, reason, additional_notes, penalty_amount, is_paid)
                VALUES (?, ?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, penalty.getNationalId());
            ps.setString(2, penalty.getReason());
            ps.setString(3, penalty.getAdditionalNotes());
            ps.setDouble(4, penalty.getPenaltyAmount());
            ps.setInt(5, penalty.getIsPaid() ? 1 : 0);
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
                SET national_id = ?, reason = ?, additional_notes = ?, penalty_amount = ?, is_paid = ?
                WHERE penalty_id = ?
                """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, penalty.getNationalId());
            ps.setString(2, penalty.getReason());
            ps.setString(3, penalty.getAdditionalNotes());
            ps.setDouble(4, penalty.getPenaltyAmount());
            ps.setInt(5, penalty.getIsPaid() ? 1 : 0);
            ps.setInt(6, penaltyId);
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
