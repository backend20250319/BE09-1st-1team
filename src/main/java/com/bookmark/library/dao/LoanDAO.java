package com.bookmark.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {
    private final Connection conn;
    
    public LoanDAO(Connection conn) {
        this.conn = conn;
    }

    public boolean hasOverdueLoans(String memberId) {
        String sql = "SELECT COUNT(*) FROM loans WHERE member_id = ? AND due_date < CURRENT_DATE AND return_date IS NULL";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberId);
            var rs = pstmt.executeQuery();
            return rs.next() && rs.getInt(1) > 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to check overdue loans", e);
        }
    }

    public int getLoanCountByMember(String memberId) {
        String sql = "SELECT COUNT(*) FROM loans WHERE member_id = ? AND return_date IS NULL";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberId);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get loan count", e);
        }
    }
    
    public int getLoanCountByBook(String isbn) {
        String sql = "SELECT COUNT(*) FROM loans WHERE isbn = ? AND return_date IS NULL";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, isbn);
            var rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getInt(1);
            }
            return 0;
        } catch (SQLException e) {
            throw new RuntimeException("Failed to get loan count for book", e);
        }
    }

    public void createLoan(String memberId, String isbn, LocalDate loanDate, LocalDate dueDate) {
        String sql = "INSERT INTO loans (member_id, isbn, loan_date, due_date) VALUES (?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberId);
            pstmt.setString(2, isbn);
            pstmt.setObject(3, loanDate);
            pstmt.setObject(4, dueDate);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Failed to create loan record", e);
        }
    }

    public List<String> getCurrentLoans(String memberId) {
        String sql = """
        SELECT b.title
        FROM loans l
        JOIN books b ON l.isbn = b.isbn
        WHERE l.member_id = ? AND l.return_date IS NULL
    """;

        List<String> loans = new ArrayList<>();

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, memberId);
            var rs = pstmt.executeQuery();
            while (rs.next()) {
                loans.add(rs.getString("title")); // 도서 제목을 리스트에 저장
            }
        } catch (SQLException e) {
            throw new RuntimeException("📛 대출 중인 도서 제목을 불러오는데 실패했습니다.", e);
        }

        return loans;
    }

}
