package com.bookmark.library.model.Login.service;

import com.bookmark.library.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;

public class SignUpService {
    public static boolean saveUser(String member_id, String password, String username, Date birth_date, String phone_number, String email) {
        String sql = """
            INSERT INTO members (member_id, password, username, birth_date, phone_number, email)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, member_id);
            stmt.setString(2, password);
            stmt.setString(3, username);
            stmt.setDate(4, birth_date);
            stmt.setString(5, phone_number);
            stmt.setString(6, email);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static boolean isDuplicateId(String member_id) {
        String sql = "SELECT COUNT(*) FROM members WHERE member_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, member_id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }

}
