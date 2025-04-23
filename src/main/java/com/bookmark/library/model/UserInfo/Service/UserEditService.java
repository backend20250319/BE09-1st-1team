package com.bookmark.library.model.UserInfo.Service;

import com.bookmark.library.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class UserEditService {
    public static boolean updateUser(String memberId, String password, String username, String phone_number, String email) {
        String sql = """
            UPDATE members
            SET password = ?, username = ?, phone_number = ?, email = ?
            WHERE member_id = ?
        """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, password);
            stmt.setString(2, username);
            stmt.setString(3, phone_number);
            stmt.setString(4, email);
            stmt.setString(5, memberId);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
