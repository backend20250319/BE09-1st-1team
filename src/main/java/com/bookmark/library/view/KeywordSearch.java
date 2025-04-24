package com.bookmark.library.view;

import com.bookmark.library.util.IO;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class KeywordSearch {
    public static void main(String[] args) {
        Scanner keyword = new Scanner(System.in);
        System.out.println("====[통합 검색]====");
        System.out.println("검색어를 입력하세요.");
        String keywordText = keyword.nextLine().toLowerCase();
        keyword.close();

        String searchPattern = "%" + keywordText + "%";
        String sql = "SELECT title, author, publisher FROM books " +
                "WHERE title LIKE '" + searchPattern + "' " +
                "OR author LIKE '" + searchPattern + "' " +
                "OR publisher LIKE '" + searchPattern + "'";
        Set<String> uniqueResults = new LinkedHashSet<>();

        SearchView.searchResults = uniqueResults;

    }

}
