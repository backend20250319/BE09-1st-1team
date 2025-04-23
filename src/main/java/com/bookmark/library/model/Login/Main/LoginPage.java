package com.bookmark.library.model.Login.Main;

import com.bookmark.library.model.Login.View.LoginFalse;
import com.bookmark.library.model.Login.service.LoginService;
import com.bookmark.library.util.IO;

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
        } else {
            LoginFalse.display();   // 로그인 실패 시 로그인 실패 페이지로 이동
        }
    }
}
