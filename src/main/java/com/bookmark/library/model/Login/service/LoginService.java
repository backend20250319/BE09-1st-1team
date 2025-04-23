package com.bookmark.library.model.Login.service;

import com.bookmark.library.util.DBUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginService {

    public boolean login(String username, String password) {
        String sql = "SELECT * FROM members WHERE member_id = ? AND password = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // 결과가 있으면 로그인 성공
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
