package com.bookmark.library.view;
import com.bookmark.library.util.IO;

import java.util.Set;
public class SearchView {
    public static Set<String> searchResults;
    private static String books;

    private static void showSearchResults() {
        System.out.println("==== [검색 결과] ====");
        if (searchResults == null || searchResults.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        int index = 1;
        for (String result : searchResults) {
            System.out.println("[" + index + "] " + result);
            index++;
        }

        System.out.println("0. 홈으로");
        System.out.println("1. 책 상세 정보");
        switch (IO.selectMenu(1)){
            case 0 -> {} //처음으로
            case 1 -> {} //상세정보
            default -> {
                System.out.println("잘못된 입력입니다.");
                return ;
            }
    }
    }


    public static Set<String> categoryResults;

    public static void setCategoryResults(Set<String> results) {
        categoryResults = results;
        showCategoryResults();
    }

    private static void showCategoryResults() {
        System.out.println("==== [카테고리 검색 결과] ====");

        if (categoryResults == null || categoryResults.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            System.out.println("===========================");
            return;
        }

        int index = 1;
        for (String book : categoryResults) {
            System.out.println("[" + index++ + "] " + book);
        }

        System.out.println("""
                
                0. 메인화면으로 이동
                1. 상세페이지로 이동
                """);

        switch (IO.selectMenu(1)) {
            case 0 -> {
                System.out.println("메인화면으로 이동합");
                // 메인 메뉴로 이동
            }
            case 1 -> {
                System.out.println("상세페이지로 이동");
                // 상세 페이지 이동
            }
            default -> {
                System.out.println("잘못된 입력입니다.");
            }
        }

        System.out.println("===========================");
    }
}
