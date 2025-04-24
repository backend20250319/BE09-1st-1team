package com.bookmark.library.dao;

import com.bookmark.library.model.Review;

import java.util.ArrayList;
import java.util.List;

public class ReviewDAO {

    // 임시 저장소(db 없이 기능만 구현하기 위해서)
    private static final List<Review> reviewList = new ArrayList<>();

    // 리뷰 추가
    public boolean insertReview(Review review) {
        //String sql = "INSERT INTO review (isbn, member_id, content, rating, review_date) VALUES (?, ?, ?, ?, ?)";
        //Connection conn = DBConnection.getConnection(); // 아직 db 연결전이라 x.

        return reviewList.add(review);
    }

    // 리뷰 목록 조회 (리뷰 자체 id으로 일단 필터링 예시 잡음)
    public List<Review> getReviewsById(int id) {
        List<Review> result = new ArrayList<>();

        for (Review review : reviewList) { // 임시 저장소인 리스트의 변수이름인데 리스트 길이만큼 출력
            if(review.getId() == id) {
                result.add(review);
            }
        }
        return result;
    }

}
