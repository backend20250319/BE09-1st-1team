package com.bookmark.library.view;

import com.bookmark.library.util.IO;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class KeywordSearch {

    // 도서 상세 페이지에서도 호출할 수 있도록 static 메서드 추가
    public static void showKerywordSearch() {
        System.out.println("====[통합 검색]====");
        System.out.println("검색어를 입력하세요.");
        String keywordText = IO.scanner.nextLine().toLowerCase();

        String searchPattern = "%" + keywordText + "%";
        String sql = "SELECT title, author, publisher FROM books " +
                "WHERE title LIKE '" + searchPattern + "' " +
                "OR author LIKE '" + searchPattern + "' " +
                "OR publisher LIKE '" + searchPattern + "'";
        Set<String> uniqueResults = new LinkedHashSet<>();

        SearchView.searchResults = uniqueResults;
    }

}
