package com.bookmark.library.dao;

import com.bookmark.library.model.Member;
import com.bookmark.library.util.DBUtil;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public static Member getUserInfo(String memberId) {
        String sql = "SELECT * FROM members WHERE member_id = ?";
        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, memberId);
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return new Member(
                            rs.getString("member_id"),
                            rs.getString("password"),
                            rs.getString("username"),
                            rs.getDate("birth_date"),
                            rs.getString("phone_number"),
                            rs.getString("email")
                    );
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    // 로그인 확인 메서드
    public static boolean validateLogin(String memberId, String password) {
        String sql = "SELECT * FROM members WHERE member_id = ? AND password = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, memberId);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next(); // 결과가 있으면 로그인 성공
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 유저 정보 조회
    public static ResultSet getUserInfo(String memberId, String password) {
        String sql = "SELECT * FROM members WHERE member_id = ? AND password = ?";
        try {
            Connection conn = DBUtil.getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, memberId);
            stmt.setString(2, password);
            return stmt.executeQuery();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    // 회원 가입 저장
    public static boolean insertUser(String memberId, String password, String username,
                                     Date birthDate, String phoneNumber, String email) {
        String sql = """
            INSERT INTO members (member_id, password, username, birth_date, phone_number, email)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, memberId);
            stmt.setString(2, password);
            stmt.setString(3, username);
            stmt.setDate(4, birthDate);
            stmt.setString(5, phoneNumber);
            stmt.setString(6, email);

            int rows = stmt.executeUpdate();
            return rows > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 아이디 중복 체크
    public static boolean isDuplicateId(String memberId) {
        String sql = "SELECT COUNT(*) FROM members WHERE member_id = ?";

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, memberId);
            try (ResultSet rs = stmt.executeQuery()) {
                return rs.next() && rs.getInt(1) > 0;
            }

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 회원정보 수정
    public static boolean updateUserInfo(String memberId, String password, String username, String phoneNumber, String email) {
        String sql = """
        UPDATE members
        SET password = ?, username = ?, phone_number = ?, email = ?
        WHERE member_id = ?
        """;

        try (Connection conn = DBUtil.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, password);
            stmt.setString(2, username);
            stmt.setString(3, phoneNumber);
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
