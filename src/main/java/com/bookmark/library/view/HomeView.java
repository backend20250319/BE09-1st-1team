package com.bookmark.library.view;

import com.bookmark.library.exception.ReturnToHomeException;
import com.bookmark.library.util.IO;

public class HomeView {
    private boolean terminate = false;

    public void showHome() {
        while (!terminate) {
            try {
                // TODO: 로그인 여부 확인
                boolean isLoggedIn = false;
                if (isLoggedIn) {
                    showLoggedIn();
                } else {
                    showNotLoggedIn();
                }
            } catch (ReturnToHomeException ignored) {
            }
        }
    }

    private void showLoggedIn() {

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
            case 1 -> registerMember();
            case 2 -> login();
            case 3 -> searchBook();
            case 4 -> viewCategories();
        }
    }

    private void registerMember() {

    }

    private void login() {
//        LoginPage page = new LoginPage();
//        page.run();
    }

    private void searchBook() {

    }

    private void viewCategories() {

    }
}
