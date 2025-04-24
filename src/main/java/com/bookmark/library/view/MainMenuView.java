package com.bookmark.library.view;

import com.bookmark.library.util.IO;

public class MainMenuView {
    /**
     * 메인 메뉴에 진입합니다.
     * @return 프로그램 종료가 요청되면 false를 반환합니다. 그 외의 경우 true를 반환합니다.
     */
    public boolean showMainMenu() {
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
            case 0 -> {
                return false;
            }
            case 1 -> registerMember();
            case 2 -> login();
            case 3 -> searchBook();
            case 4 -> viewCategories();
        }

        return true;
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
