package com.bookmark.library.dao;

import com.bookmark.library.model.Book;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDAO {
    private final Connection conn;

    public CategoryDAO(Connection conn) {
        this.conn = conn;
    }

    public List<Book> getBooksByCategory(String categoryName) {
        List<Book> books = new ArrayList<>();

        String sql = "SELECT * FROM books b " +
                "JOIN categories c ON b.category_id = c.category_id " +
                "WHERE c.category_name = ?";

        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, categoryName);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                Book book = new Book();    // 컬럼 이름 확인 필요
                book.setTitle(rs.getString("title"));
                book.setAuthor(rs.getString("author"));
                book.setCategoryId(rs.getInt("category_id"));
                // 필요한 경우 book.setPublisher(...) 등 추가

                books.add(book); // 중요!
            }

        } catch (SQLException e) {
            e.printStackTrace(); // 실제 서비스에서는 로깅 처리 권장
        }

        return books;
    }

    public String getCategoryNameById(int categoryId) {
        String sql = "SELECT category_name FROM categories WHERE category_id = ?";
        try (PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, categoryId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getString("category_name");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
