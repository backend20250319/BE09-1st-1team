package com.bookmark.library.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
    private static final String URL = "jdbc:mysql://localhost:3322/librarydb";
    private static final String USER = "bookmark";  // 사용자명
    private static final String PASSWORD = "7bqnW3utj4tgaJWPyusu";  // 실제 비밀번호 입력

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver"); // 드라이버 로딩
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
