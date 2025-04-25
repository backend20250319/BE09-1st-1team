package com.bookmark.library.view;

import com.bookmark.library.service.SearchService;
import com.bookmark.library.service.Services;
import com.bookmark.library.util.IO;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

public class KeywordSearchView {
    private final SearchService searchService = Services.resolve(SearchService.class);

    public void runKeywordSearch() {
        System.out.print("검색어: ");
        String keywordText = IO.scanner.nextLine().toLowerCase();

        var results = searchService.search(keywordText);
        var resultView = new SearchResultView(results);
        resultView.showSearchResults();
    }
}
