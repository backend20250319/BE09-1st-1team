package com.bookmark.library.view.loginview;

import com.bookmark.library.util.IO;
import com.bookmark.library.view.MainMenuView;

public class LoginFalse {
    public static void display() {
        System.out.print("""
            ==== BOOKMARK ====
            ❌ 로그인 실패. 다시 시도해주세요.
            
            1. 다시 로그인하기
            0. 홈으로
            >>>  """);
        int choice = IO.readIntLine();
        switch (choice) {
            case 1 -> {
                new LoginPage().run();  // 로그인 페이지 재시도
                return;
            }
            case 0 -> {
                new MainMenuView().showMainMenu();  // 메인 메뉴로 이동
                return;
            }
            default -> System.out.println("⚠️ 올바른 번호를 입력해주세요.");
        }
    }
}
