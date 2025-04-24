package com.bookmark.library.view;

import com.bookmark.library.auth.LoginContext;
import com.bookmark.library.exception.ReturnToHomeException;
import com.bookmark.library.util.IO;
import com.bookmark.library.view.loginview.LoginPage;
import com.bookmark.library.view.loginview.SignUpPage;
import com.bookmark.library.view.userinfoview.UserInfoPage;

public class HomeView {
    private boolean terminate = false;

    public void showHome() {
        while (!terminate) {
            try {
                if (LoginContext.isLoggedIn()) {
                    showLoggedIn();
                } else {
                    showNotLoggedIn();
                }
            } catch (ReturnToHomeException ignored) {
            }
        }
    }

    private void showLoggedIn() {
        System.out.print("""
                
                ==== BOOKMARK ====
                도서 대출 관리 시스템
                
                1. 마이페이지
                2. 로그아웃
                3. 통합검색
                4. 카테고리 전체보기
                0. 프로그램 종료
                """);

        switch (IO.selectMenu(4)) {
            case 0 -> terminate = true;
            case 1 -> UserInfoPage.run();
            case 2 -> logout();
            case 3 -> searchBook();
            case 4 -> viewCategories();
        }
    }

    private void showNotLoggedIn() {
        System.out.print("""
                
                ==== BOOKMARK ====
                도서 대출 관리 시스템
                
                1. 회원가입
                2. 로그인
                3. 통합검색
                4. 카테고리 전체보기
                0. 프로그램 종료
                """);

        switch (IO.selectMenu(4)) {
            case 0 -> terminate = true;
            case 1 -> SignUpPage.run();
            case 2 -> LoginPage.run();
            case 3 -> searchBook();
            case 4 -> viewCategories();
        }
    }

    private void logout() {
        LoginContext.logout();
        System.out.println("로그아웃 되었습니다.");
    }

    private void searchBook() {

    }

    private void viewCategories() {

    }
}
