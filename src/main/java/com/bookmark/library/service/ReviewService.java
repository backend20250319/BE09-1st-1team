package com.bookmark.library.service;

import com.bookmark.library.dao.ReviewDAO;
import com.bookmark.library.model.Review;

public class ReviewService {

    private ReviewDAO reviewDAO = new ReviewDAO();

    public boolean writeReview(Review review) {
        if(review.getContent() == null || review.getContent().isEmpty()) {
            return false;
        }
        return reviewDAO.insertReview(review);
    }
}
