package com.bookmark.library.view;

import com.bookmark.library.model.Book;
import com.bookmark.library.util.IO;

import java.util.List;

public class SearchResultView {
    public static List<Book> searchResults;

    public SearchResultView(List<Book> results) {
        this.searchResults = results;
    }

    public void showSearchResults() {
        System.out.println("\n==== [검색 결과] ====");
        if (searchResults == null || searchResults.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        for (int i = 0; i < searchResults.size(); i++) {
            Book book = searchResults.get(i);
            System.out.println("[" + (i+1) + "] " + book.title());
        }
        System.out.println("0. 돌아가기");

        int choice = IO.selectMenu(searchResults.size());
        if (choice == 0) return;

        Book book = searchResults.get(choice - 1);
        var detailView = new ShowBookDetailView();
        detailView.showBookDetail(book);
    }


    public static List<Book> categoryResults;

    public static void setCategoryResults(List<Book> results) {
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
        for (Book book : categoryResults) {
            System.out.println("[" + index++ + "] " + book.title() + " - " + book.author());
        }

        System.out.println("""
        
        0. 메인화면으로 이동
        1 ~ N. 상세페이지로 이동
        """);

        int choice = IO.selectMenu(categoryResults.size());
        if (choice == 0) return;

        Book book = categoryResults.get(choice - 1);
        var detailView = new ShowBookDetailView();
        detailView.showBookDetail(book);

        System.out.println("===========================");
    }

}
