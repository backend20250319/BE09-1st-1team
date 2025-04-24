package com.bookmark.library.view.loginview;

import com.bookmark.library.auth.LoginContext;
import com.bookmark.library.model.Member;
import com.bookmark.library.service.LoginService;
import com.bookmark.library.util.IO;
import com.bookmark.library.view.HomeView;
import com.bookmark.library.view.userinfoview.UserInfoPage;

public class LoginPage {

    public static void run() {
        LoginService service = new LoginService();
        System.out.println("==== BOOKMARK ====");

        System.out.print("아이디를 입력하세요: ");
        String username = IO.scanner.nextLine();

        System.out.print("비밀번호를 입력하세요: ");
        String password = IO.scanner.nextLine();

        if (LoginContext.login(username, password)) {
            System.out.println("✅ 로그인 성공!");

            Member user = LoginContext.getCurrentUser();
            if (user == null) {
                System.out.println("❌ 사용자 정보를 불러오는 데 실패했습니다.");
                return;
            }

            // 현재 로그인된 사용자 정보 출력 (선택)
            System.out.println("환영합니다, " + user.getUsername() + "님!");

            new HomeView().showHome();
        } else {
            LoginFalse.display(); // 로그인 실패 시 로그인 실패 페이지로 이동
        }
    }
}
