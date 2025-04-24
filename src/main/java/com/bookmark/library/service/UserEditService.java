package com.bookmark.library.service;

import com.bookmark.library.dao.MemberDAO;
//import com.bookmark.library.util.DBUtil;
//
//import java.sql.Connection;
//import java.sql.PreparedStatement;

public class UserEditService {
    public static boolean updateUser(String memberId, String password, String username, String phoneNumber, String email) {
        return MemberDAO.updateUserInfo(memberId, password, username, phoneNumber, email);
    }
}
