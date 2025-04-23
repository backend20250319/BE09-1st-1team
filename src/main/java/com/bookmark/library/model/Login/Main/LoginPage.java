package com.bookmark.library.model.Login.Main;

import com.bookmark.library.model.Login.Session.SessionUser;
import com.bookmark.library.model.Login.View.LoginFalse;
import com.bookmark.library.model.Login.service.LoginService;
import com.bookmark.library.model.UserInfo.Main.UserInfoPage;
import com.bookmark.library.util.IO;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;

public class LoginPage {

    public static void main(String[] args) {
        run(); // IntelliJ에서 실행될 때 진입점
    }

    public static void run() {
        LoginService service = new LoginService();
        System.out.println("==== BOOKMARK ====");

        System.out.print("아이디를 입력하세요: ");
        String username = IO.scanner.nextLine();

        System.out.print("비밀번호를 입력하세요: ");
        String password = IO.scanner.nextLine();

        if (service.login(username, password)) {
            System.out.println("✅ 로그인 성공!");


            ResultSet rs = service.findUser(username, password);
            try {
                try {
                    if (rs != null && rs.next()) {
                        String member_id = rs.getString("member_id");
                        String name = rs.getString("username");
                        Date birth_date = rs.getDate("birth_date");
                        String email = rs.getString("email");

                        SessionUser session = SessionUser.getInstance();
                        session.setUser(member_id, name, birth_date, email);
                    }
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            } finally {
                try {
                    rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }
            UserInfoPage.run();
        }  else{
            LoginFalse.display();   // 로그인 실패 시 로그인 실패 페이지로 이동
        }
    }
}
