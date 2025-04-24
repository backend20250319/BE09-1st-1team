package com.bookmark.library.service;

import com.bookmark.library.dao.MemberDAO;

import java.sql.ResultSet;

public class LoginService {
    public boolean login(String memberId, String password) {
        return MemberDAO.validateLogin(memberId, password);
    }

    public ResultSet findUser(String memberId, String password) {
        return MemberDAO.getUserInfo(memberId, password);
    }
}
