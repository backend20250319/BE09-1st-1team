package com.bookmark.library.dao;

import com.bookmark.library.model.Book;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {
    private final Connection conn;
    
    public BookDAO(Connection conn){
        this.conn = conn;
    }

    public static List<Book> getBooksByCategory(int categoryId) {
        return List.of(); // TODO: 나중에 구현
    }

    public void insertBook(Book book) throws SQLException {
        String sql = "INSERT INTO books (isbn, title, category_id, author, publisher, publish_date, introduction, stock_quantity, age_limit) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, book.isbn());
            pstmt.setString(2, book.title());
            pstmt.setInt(3, book.categoryId());
            pstmt.setString(4, book.author());
            pstmt.setString(5, book.publisher());
            pstmt.setDate(6, Date.valueOf(book.publishDate()));
            pstmt.setString(7, book.introduction());
            pstmt.setInt(8, book.stockQuantity());
            pstmt.setInt(9, book.ageLimit());
            pstmt.executeUpdate();
        }
    }

    public List<Book> searchBooks(String keyword) {
        String sql = "SELECT * FROM books WHERE LOWER(title) LIKE ? OR LOWER(author) LIKE ?";
        List<Book> books = new ArrayList<>();
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
            String searchPattern = "%" + keyword.trim().toLowerCase() + "%";
            pstmt.setString(1, searchPattern);
            pstmt.setString(2, searchPattern);

            try (var rs = pstmt.executeQuery()) {
                while (rs.next()) {
                    books.add(new Book(
                            rs.getString("isbn"),
                            rs.getString("title"),
                            rs.getInt("category_id"),
                            rs.getString("author"),
                            rs.getString("publisher"),
                            rs.getDate("publish_date").toLocalDate(),
                            rs.getInt("stock_quantity"),
                            rs.getString("introduction"),
                            rs.getInt("age_limit")
                    ));
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException("Failed to search books", e);
        }
        return books;
    }
}
