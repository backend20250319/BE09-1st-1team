package com.bookmark.library.view;
import com.bookmark.library.model.Book;
import com.bookmark.library.util.IO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
public class SearchResultView {
    public static List<Book> searchResults;

    public SearchResultView(List<Book> results) {
        this.searchResults = results;
    }

    private void showSearchResults() {
        System.out.println("==== [검색 결과] ====");
        if (searchResults == null || searchResults.isEmpty()) {
            System.out.println("검색 결과가 없습니다.");
            return;
        }

        for (int i = 0; i < searchResults.size(); i++) {
            Book book = searchResults.get(i);
            System.out.println("[" + (i+1) + "] " + book.getTitle());
        }
        System.out.println("0. 뒤로");

        int choice = IO.selectMenu(searchResults.size());
        if (choice == 0) return;

        Book book = searchResults.get(choice - 1);
        ShowBookDetailView.showBookDetail(book);
    }


    public static List<Book> categoryResults;

    public static void setCategoryResults(Set<Book> results) {
        categoryResults = new ArrayList<>(results);
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
            System.out.println("[" + index++ + "] " + book.getTitle() + " - " + book.getAuthor());
        }

        System.out.println("""
        
        0. 메인화면으로 이동
        1 ~ N. 상세페이지로 이동
        """);

        int choice = IO.selectMenu(categoryResults.size());
        if (choice == 0) return;

        Book book = categoryResults.get(choice - 1);
        ShowBookDetailView.showBookDetail(book);

        System.out.println("===========================");
    }

}
