package com.bookmark.library.view;

import com.bookmark.library.auth.LoginContext;
import com.bookmark.library.dao.LoanDAO;
import com.bookmark.library.exception.LoanFailureException;
import com.bookmark.library.model.Book;
import com.bookmark.library.model.Member;
import com.bookmark.library.model.Review;
import com.bookmark.library.service.LoanService;
import com.bookmark.library.service.ReviewService;
import com.bookmark.library.util.IO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ShowBookDetailView {
    Book book = new Book();
    private static Member currentMember = null; // 현재 로그인한 회원
    private static ReviewService reviewService = new ReviewService();


    /***
     *  BOOK-005: 도서 상세 정보 표시
     * @param book
     */
    public static void showBookDetail(Book book) {
        List<Review> reviews = reviewService.getReviewsByiSbn(book.getIsbn());
        book.setReviews(reviews);
        LoanDAO loanDAO = new LoanDAO();
        LoanService loanService = new LoanService(loanDAO);

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
                System.out.println("사용자 ID: " + review.getMemberId());
                System.out.println(" \"" + review.getContent() + "\"");
                System.out.println(" 별점 : " + "★".repeat(Math.max(0,review.getRating())) + "☆".repeat(5 - review.getRating()));
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
                    //
                    return;
                case 1:
                    handleLoan(book);
                    break;
                case 2:
                    // 리뷰 작성 페이지로 이동 코드
                    WriteReviewView.writeReview(book);
                    showBookDetail(book); // 리뷰 작성 후 상세 보기로 자동 복귀
                    break;
                default:
                    System.out.println("잘못된 입력입니다.");
                    showBookDetail(book);
            }

        } catch (Exception e) {
            // 예외 처리 코드
            System.out.println("잘못된 입력입니다. 선택 메뉴에 있는 번호를 입력해주세요.");
            throw new RuntimeException(e);
        }

    }

    private static void handleLoan(Book book) {
        if (! LoginContext.isLoggedIn()) {
            System.out.println("⚠ 로그인 후 이용 가능한 서비스입니다.");
            showBookDetail(book);
            return;
        }

        Member currentMember = LoginContext.getCurrentUser();
        LoanService loanService = new LoanService(new LoanDAO());

        try {
            loanService.loanBook(currentMember, book);
            System.out.println("📘 도서가 성공적으로 대출되었습니다!\"");
        } catch (LoanFailureException e) {
            System.out.println("❌ 대출 실패 : + e.getReason().getMessage()");
        } catch (Exception e) {
            System.out.println("⚠ 대출 처리 중 오류가 발생했습니다. ");
        }

        showBookDetail(book);
    }


}
