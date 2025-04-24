package com.bookmark.library.view;

import com.bookmark.library.Main;
import com.bookmark.library.auth.LoginContext;
import com.bookmark.library.model.Book;
import com.bookmark.library.model.Member;
import com.bookmark.library.model.Review;
import com.bookmark.library.service.ReviewService;
import com.bookmark.library.util.IO;

import java.util.ArrayList;
import java.util.Date;

// 리뷰 작성 페이지
public class WriteReviewView {
    // 기능 확인용 main문
    public static void main(String[] args) {
        // 테스트용 Book 객체 생성
        Book testBook = new Book(
                "978-89-6848-556-3",
                "자바의 정석",
                1,
                "남궁성",
                "도우출판",
                new Date(),
                5,
                10,
                "자바의 기초부터 객체지향개념을 넘어 실전활용까지",
                new ArrayList<>(),
                12
        );

        // 테스트를 위해 임시로 로그인 상태 설정
        Member testuser = new Member(); // 멤버 객체 연결
        testuser.setId("testuser1");

        // 필요한 경우 다른 회원 정보도 설정
        LoginContext.login(testuser);

        // 리뷰 작성 페이지 테스트
        WriteReviewView.writeReview(testBook);
    }

    public static void writeReview(Book book) {

        if (LoginContext.isLoggedIn()) {
            Member user = LoginContext.getCurrentUser();
            System.out.println("로그인한 사용자 ID : " + user.getId());

            System.out.println("=== [📝 리뷰 작성] ===\n");
            System.out.println("내용을 입력하세요:");
            System.out.print("> ");
            String content = IO.scanner.nextLine().trim();
            System.out.println();

            int rating = 0;
            while (true) {
                System.out.print("별점 선택 (1 ~ 5): ");
                try {
                    rating = IO.scanner.nextInt();
                    IO.scanner.nextLine(); // 버퍼 비우기

                    if (rating >= 1 && rating <= 5) break;
                    System.out.println("⚠ 1에서 5 사이의 숫자를 입력해주세요.");
                } catch (Exception e) {
                    System.out.println("⚠ 유효한 숫자를 입력해주세요.");
                    IO.scanner.nextLine(); // 잘못된 입력 제거
                }
            }

            Review review = new Review();
            review.setMemberId(user.getId()); // 로그인한 사용자 ID 설정
            review.setIsbn(book.getIsbn());
            review.setContent(content);
            review.setRating(rating);
            review.setReviewDate(new Date());

            ReviewService reviewService = new ReviewService();
            boolean success = reviewService.writeReview(review);
            if (success) {
                System.out.println("✅ 리뷰가 등록되었습니다! 감사합니다.");
            } else {
                System.out.println("⚠ 리뷰 등록에 실패했습니다. 다시 시도해주세요.");
            }

        } else {
            System.out.println("⚠ 리뷰를 작성하려면 로그인이 필요합니다.");
        }
        System.out.println("(확인: ENTER)"); // 일단 넣어놈.
        ShowBookDetailView.showBookDetail(book); // 흐름을 위해 리뷰 작성이 끝난 후 다시 도서 상세 페이지로 돌아가도록 함.

    }
}
