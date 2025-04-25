package com.bookmark.library.view.userinfoview;

import com.bookmark.library.auth.LoginContext;
import com.bookmark.library.exception.ReturnToHomeException;
import com.bookmark.library.model.Member;
import com.bookmark.library.Main;
import com.bookmark.library.service.LoanService;
import com.bookmark.library.service.Services;
import com.bookmark.library.util.IO;
import com.bookmark.library.dao.LoanDAO;

import java.sql.Connection;
import java.util.List;

public class UserInfoPage {
    private final LoanService loanService = Services.resolve(LoanService.class);

    public void run() {
        Member user = LoginContext.getCurrentUser();

        System.out.println();
        System.out.println("==== 마이페이지 ====");
        System.out.println("아이디: " + user.getId());
        System.out.println("이름: " + user.getUsername());
        System.out.println("생년월일: " + user.getBirthDate());
        System.out.println("전화번호: " + user.getPhoneNumber());
        System.out.println("이메일: " + user.getEmail());
        try {
            List<String> loans = loanService.getCurrentLoans(LoginContext.getCurrentUser().getId()); // 👈 이렇게 가능

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

        System.out.println();
        System.out.print("""
                1. 개인정보 수정
                2. 반납
                0. 뒤로가기
                """);
        int choice = IO.selectMenu(2);

        switch (choice) {
            case 1 -> new InfoEditPage().run(); // 개인정보 수정 화면 이동
            case 2 -> System.out.println("아직 구현되지 않은 기능입니다.");  // 반납 메뉴 이동
            case 0 -> { return; } // 뒤로가기
        }
    }
}
