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

    // 리뷰 목록 조회 - 리뷰 자체 id로 불러들임.
    public List<Review> getReviewsById(int id) {
        return reviewDAO.getReviewsById(id);
    }
}
