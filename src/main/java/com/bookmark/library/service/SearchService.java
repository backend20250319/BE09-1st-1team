package com.bookmark.library.service;

import com.bookmark.library.dao.BookDAO;
import com.bookmark.library.model.Book;

import java.util.List;

public class SearchService {
    private final BookDAO bookDAO;

    public SearchService(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }

    public List<Book> search(String query) {
        return bookDAO.searchBooks(query);
    }
}
