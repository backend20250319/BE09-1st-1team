package com.bookmark.library.view.loginview;

import com.bookmark.library.model.Session.SessionUser;
import com.bookmark.library.service.LoginService;
import com.bookmark.library.util.IO;
import com.bookmark.library.view.userinfoview.UserInfoPage;

import java.sql.ResultSet;
import java.sql.Date;
import java.sql.SQLException;

public class LoginPage {

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
                if (rs != null && rs.next()) {
                    String member_id = rs.getString("member_id");
                    String name = rs.getString("username");
                    Date birth_date = rs.getDate("birth_date");
                    String phone_number = rs.getString("phone_number");
                    String email = rs.getString("email");

                    SessionUser session = SessionUser.getInstance();
                    session.setUser(member_id, name, birth_date, phone_number, email);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            } finally {
                try {
                    if (rs != null) rs.close();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            }

            UserInfoPage.run();
        } else {
            LoginFalse.display(); // 로그인 실패 시 로그인 실패 페이지로 이동
        }
    }
}
