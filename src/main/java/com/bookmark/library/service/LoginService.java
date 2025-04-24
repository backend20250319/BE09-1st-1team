package com.bookmark.library.service;

import com.bookmark.library.dao.MemberDAO;
import com.bookmark.library.model.Member;

import java.sql.ResultSet;

public class LoginService {
    public boolean login(String memberId, String password) {
        return MemberDAO.validateLogin(memberId, password);
    }

    public Member findUser(String memberId, String password) {
        return MemberDAO.getUserInfo(memberId, password);  // ✅ Member 객체 반환
    }
}
