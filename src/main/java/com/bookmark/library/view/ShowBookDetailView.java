package com.bookmark.library.view;

import com.bookmark.library.model.Book;
import com.bookmark.library.model.Review;
import com.bookmark.library.service.LoanService;
import com.bookmark.library.service.ReviewService;
import com.bookmark.library.service.Services;
import com.bookmark.library.util.IO;

import java.util.List;

public class ShowBookDetailView {
    private final ReviewService reviewService = Services.resolve(ReviewService.class);
    private final LoanService loanService = Services.resolve(LoanService.class);

    /***
     *  BOOK-005: 도서 상세 정보 표시
     * @param book
     */
    public void showBookDetail(Book book) {
        List<Review> reviews = reviewService.getReviewsByiSbn(book.isbn());

        System.out.println("=== [도서 상세 정보] ===");
        System.out.println();
        System.out.println("📘 도서명: " + book.title());
        System.out.println(" ✍ 저자: " + book.author());
        System.out.println("🏢 출판사: " + book.publisher());
        System.out.println("📅 출간일: " + book.publishDate());

        System.out.print("📦 재고 현황: ");
        int loanCount = loanService.getLoanCountByBook(book.isbn());
        int remaining = Math.max(0, book.totalStock() - loanCount);
        if (remaining > 0) {
            System.out.println(remaining + "/" + book.totalStock() + " (대출 가능)");
        } else {
            System.out.println(IO.RED + remaining + "/" + book.totalStock() + " (대출 불가)" + IO.RESET);
        }

        System.out.println("📖 책 소개:\n" + book.introduction());

        // 리뷰 출력
        System.out.println("💬 리뷰");
        if (reviews.isEmpty()) {
            System.out.println("아직 등록된 리뷰가 없습니다.");
        } else {
            for (Review review : reviews) {
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
        switch (choice) {
            case 0:
                System.out.println("통합 검색 페이지로 돌아갑니다.");
                return;
            case 1:
                // 대출하기
                var loanView = new LoanView();
                loanView.showLoanPage(book);
                showBookDetail(book); // 대출 완료 후 상세 보기로 돌아옴.
                break;
            case 2:
                // 리뷰 작성 페이지로 이동 코드
                new WriteReviewView().writeReview(book);
                showBookDetail(book); // 리뷰 작성 후 상세 보기로 자동 복귀
                break;
            default:
                System.out.println("잘못된 입력입니다.");
                showBookDetail(book);
        }
    }
}
