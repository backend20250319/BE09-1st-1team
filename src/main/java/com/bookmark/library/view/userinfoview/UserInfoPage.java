package com.bookmark.library.view.userinfoview;

import com.bookmark.library.model.Session.SessionUser;
import com.bookmark.library.util.IO;

public class UserInfoPage {
    public static void run() {
        SessionUser session = SessionUser.getInstance();

        System.out.println("==== BOOKMARK MYPAGE ====");
        System.out.println(session.getUsername() + "의 마이페이지");
        System.out.println("아이디: " + session.getMemberId());
        System.out.println("이름: " + session.getUsername());
        System.out.println("생년월일: " + session.getBirthDate());
        System.out.println("전화번호:" + session.getPhone_number());
        System.out.println("이메일: " + session.getEmail());
        System.out.println();// 대출 중인 도서 목록 출력
        System.out.print("""
                1. 개인정보 수정
                2. 반납
                0. 뒤로가기
                """);
        int choice = IO.selectMenu(2);

        switch (choice) {
            case 1 -> InfoEditPage.run(); // 개인정보 수정 화면 이동
//            case 0 -> MainMenuView.run();  // 메인 메뉴로 이동
            default -> System.out.println("⚠️ 올바른 번호를 입력해주세요.");
        }
    }

}
