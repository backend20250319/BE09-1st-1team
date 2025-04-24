package com.bookmark.library.service;

import com.bookmark.library.dao.ReviewDAO;
import com.bookmark.library.model.Review;

import java.util.List;

public class ReviewService {

    private ReviewDAO reviewDAO = new ReviewDAO();

    // 리뷰 작성
    public boolean writeReview(Review review) {
        if(review.getContent() == null || review.getContent().isEmpty()) {
            return false;
        }
        return reviewDAO.insertReview(review);
    }

    // 특정 도서의 모든 리뷰 가져오기 (ISBN 기준)
    public List<Review> getReviewsByiSbn(String isbn) {
        return reviewDAO.getReviewsByIsbn(isbn);
    }
}
