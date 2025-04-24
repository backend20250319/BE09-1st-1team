package com.bookmark.library.dao;

import com.bookmark.library.model.Book;
import com.bookmark.library.model.Review;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import java.util.Set;

public class BookDAO {
    private Connection conn;
    public BookDAO(Connection conn){
        this.conn = conn;
    }

    public static List<Book> getBooksByCategory(int categoryId) {
        return List.of(); // TODO: 나중에 구현
    }

    public void insertBook(Book book)throws SQLException {
        String sql = "insert into books values(isbn,title,category_id,author,publisher,publish_date,introduction,stock_quantity,age_limit)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try(PreparedStatement pstmt = conn.prepareStatement(sql)){
            pstmt.setString(1, book.getIsbn());
            pstmt.setString(2, book.getTitle());
            pstmt.setInt(3, book.getCategoryId());
            pstmt.setString(4, book.getAuthor());
            pstmt.setString(5, book.getPublisher());
            pstmt.setDate(6, new Date(book.getPublishDate().getTime()));
            pstmt.setString(7, book.getIntroduction());
            pstmt.setInt(8, book.getStockQuantity());
            pstmt.setInt(9, book.getAgeLimit());
            pstmt.executeUpdate();

        }
    }



}
