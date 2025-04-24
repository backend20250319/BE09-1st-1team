package com.bookmark.library.view;

import com.bookmark.library.dao.BookDAO;
import com.bookmark.library.util.IO;

import java.util.Set;

public class CategorySearchView {

    public boolean showCategoryView() {
        System.out.println("""
                 ==== [도서 카테고리 선택] ====

                 1. 문학
                 2. 과학 및 기술
                 3. 취미·예술·생활
                 4. 자기계발·비즈니스
                 0. 뒤로가기
                """);

        int category_id = IO.selectMenu(4);

        if (category_id == 0) return false;
        if (category_id < 1 || category_id > 4) {
            System.out.println("잘못된 입력입니다.");
            return true;
        }

        Set<String> results = BookDAO.getBooksByCategory(category_id);
        SearchResultView.setCategoryResults(results);
        return true;
    }
}
