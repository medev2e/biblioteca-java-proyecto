package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.base.LoanModel;
import util.DatabaseUtil;

public class LoanDAO {

    public void insertLoan(LoanModel loan) {
        String sql = """
                INSERT INTO loans (national_id, isbn_number, loan_date, return_date)
                VALUES (?, ?, ?, ?)
                    """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loan.getNationalId());
            ps.setString(2, loan.getIsbnNumber());
            ps.setDate(3, Date.valueOf(loan.getLoanDate()));
            ps.setDate(4, Date.valueOf(loan.getReturnDate()));
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet searchLoansByUser(String natinalId, int page, int pageSize) {
        String sql = "SELECT * FROM loans WHERE natinal_id = ? LIMIT ? OFFSET ?";

        try {
            Connection conn = DatabaseUtil.getLibraryConnection();
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, natinalId);
            ps.setInt(2, pageSize);
            ps.setInt(3, (page - 1) * pageSize);
            return ps.executeQuery();
        } catch (Exception e) {
            return null;
        }
    }

    public void updateLoan(int loanId, LoanModel loan) {
        String sql = """
                UPDATE loans
                SET national_id = ?, isbn_number = ?, loan_date = ?, return_date = ?
                WHERE loan_id = ?
                """;

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, loan.getNationalId());
            ps.setString(2, loan.getIsbnNumber());
            ps.setDate(3, Date.valueOf(loan.getLoanDate()));
            ps.setDate(4, Date.valueOf(loan.getReturnDate()));
            ps.setInt(8, loanId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public void deleteLoan(int loanId) {
        String sql = "DELETE FROM loans WHERE loan_id = ?";

        try (Connection conn = DatabaseUtil.getLibraryConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, loanId);
            ps.executeUpdate();
        } catch (Exception e) {
        }
    }

    public ResultSet allLoans(int page, int pageSize) {
        String sql = "SELECT * FROM loans LIMIT ? OFFSET ?";

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
