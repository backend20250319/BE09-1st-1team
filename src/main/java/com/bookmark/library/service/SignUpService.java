package com.bookmark.library.service;

import com.bookmark.library.dao.MemberDAO;
import java.sql.Date;

//import com.bookmark.library.util.DBUtil;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;

public class SignUpService {
    public static boolean saveUser(String member_id, String password, String username, Date birth_date, String phone_number, String email) {
        return MemberDAO.insertUser(member_id, password, username, birth_date, phone_number, email);
    }

    public static boolean isDuplicateId(String member_id) {
        return MemberDAO.isDuplicateId(member_id);
    }

}
