package com.bookmark.library.view.userinfoview;

import com.bookmark.library.auth.LoginContext;
import com.bookmark.library.model.Member;
import com.bookmark.library.util.DBUtil;
import com.bookmark.library.util.IO;
import com.bookmark.library.dao.LoanDAO;

import java.sql.Connection;
import java.util.List;

public class UserInfoPage {
    public static void run() {
        Member user = LoginContext.getCurrentUser();

        System.out.println("==== BOOKMARK MYPAGE ====");
        System.out.println(user.getUsername() + "의 마이페이지");
        System.out.println("아이디: " + user.getId());
        System.out.println("이름: " + user.getUsername());
        System.out.println("생년월일: " + user.getBirthDate());
        System.out.println("전화번호: " + user.getPhoneNumber());
        System.out.println("이메일: " + user.getEmail());
        try (Connection conn = DBUtil.getConnection()) {
            LoanDAO loanDAO = new LoanDAO(conn);
            List<String> loans = loanDAO.getCurrentLoans(LoginContext.getCurrentUser().getId()); // 👈 이렇게 가능

            System.out.println("\n📚 대출 중인 도서 목록:");
            if (loans.isEmpty()) {
                System.out.println(" - 현재 대출 중인 도서가 없습니다.");
            } else {
                for (int i = 0; i < loans.size(); i++) {
                    System.out.println(" - [" + (i + 1) + "] " + loans.get(i));
                }
            }
        } catch (Exception e) {
            System.out.println("⚠️ 대출 목록을 불러오는 중 오류가 발생했습니다.");
            e.printStackTrace();
        }


        System.out.print("""
                1. 개인정보 수정
                2. 반납
                0. 뒤로가기
                """);
        int choice = IO.selectMenu(2);

        switch (choice) {
            case 1 -> InfoEditPage.run(); // 개인정보 수정 화면 이동
            case 0 -> throw new RuntimeException();  // 메인 메뉴로 이동
            default -> {
                if (choice < 0 || choice > 1) { // 0, 1 제외 오류 출력
                    System.out.println("⚠️ 올바른 번호를 입력해주세요.");
                }
            }
        }
    }

}
