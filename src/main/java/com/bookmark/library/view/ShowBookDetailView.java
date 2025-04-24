package com.bookmark.library.view;

import com.bookmark.library.auth.LoginContext;
import com.bookmark.library.model.Book;
import com.bookmark.library.model.Member;
import com.bookmark.library.model.Review;
import com.bookmark.library.service.ReviewService;
import com.bookmark.library.util.IO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// 도서 상세 표시
public class ShowBookDetailView {
    Book book = new Book();
    private static Member currentMember = null; // 현재 로그인한 회원

    private static ReviewService reviewService = new ReviewService();

    public static void showBookDetail(Book book) {
        System.out.println("=== [도서 상세 정보] ===");
        System.out.println();
        System.out.println("📘 도서명: " + book.getTitle());
        System.out.println(" ✍ 저자: " + book.getAuthor());
        System.out.println("🏢 출판사: " + book.getPublisher());
        System.out.println("📅 출간일: " + book.getPublishDate());
        System.out.println("📦 재고 현황: " + book.getStockQuantity() + " / " + book.getTotalStock() +
                "권 (" + (book.isAvailable() ? "대출 가능" : "대출 불가") + ")");
        System.out.println("📖 책 소개: " + book.getIntroduction());

        // 리뷰 표시
        System.out.println("💬 리뷰");
        if (book.getReviews().isEmpty()) {
            System.out.println("아직 등록된 리뷰가 없습니다.");
        } else {
            for (Review review : book.getReviews()) {
                System.out.println("사용자 ID: " + review.getId());
                System.out.println(" \"" + review.getContent() + "\"");
                System.out.println(" 별점 : " + "★".repeat(review.getRating()) + "☆".repeat(review.getRating()));
                System.out.println();
            }
        }

        // 메뉴 출력
        System.out.println("1. 대출하기");
        System.out.println("2. 리뷰하기");
        System.out.println("0. 뒤로가기");

        // 사용자 입력 처리 - 메뉴 최대값은 2
        int choice = IO.selectMenu(2);

        try {

            switch (choice) {
                case 0:
                    // 통합 검색 페이지로 이동 코드
                    System.out.println("통합 검색 페이지로 돌아갑니다.");
                    KeywordSearch.showKerywordSearch();
                    return;
                case 1:
                    // 대출 기능 구현 예정
                    if (LoginContext.isLoggedIn()) {
                        Member user = LoginContext.getCurrentUser();
                        //BorrowBookView.borrowBook(book, user); // ← 팀원이 만든 기능 호출
                    } else {
                        System.out.println("로그인이 필요합니다.");
                    }
                    break;
                case 2:
                    // 리뷰 작성 페이지로 이동 코드
                    WriteReviewView.writeReview(book);
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
            }

        } catch (Exception e) {
            // 예외 처리 코드
            System.out.println("잘못된 입력입니다. 선택 메뉴에 있는 번호를 입력해주세요.");
            throw new RuntimeException(e);
        }

    }




}
