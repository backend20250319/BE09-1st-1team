package com.bookmark.library.view;

import com.bookmark.library.service.SearchService;
import com.bookmark.library.util.IO;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class KeywordSearchView {
    private final SearchService searchService;

    public KeywordSearchView(SearchService searchService) {
        this.searchService = searchService;
    }

    public void runKeywordSearch() {
        System.out.println("====[통합 검색]====");
        System.out.println("검색어를 입력하세요.");
        String keywordText = IO.scanner.nextLine().toLowerCase();

        var results = searchService.search(keywordText);
        var resultView = new SearchResultView(results);
    }
}
