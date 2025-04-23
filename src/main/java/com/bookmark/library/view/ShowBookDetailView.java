package com.bookmark.library.view;

import com.bookmark.library.model.Book;
import com.bookmark.library.util.IO;

import java.util.ArrayList;
import java.util.Date;

// 도서 상세 표시
public class ShowBookDetailView {
    Book book = new Book();

    //book.searchBook();
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

        // 도서 상세 정보 출력
        ShowBookDetailView.showBookDetail(testBook);
    }

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
//        System.out.println("💬 리뷰");
//        if (book.getReviews().isEmpty()) {
//            System.out.println("아직 등록된 리뷰가 없습니다.");
//        } else {
//            for (Review review : book.getReviews()) {
//                System.out.println("사용자 ID: " + review.getId());
//                System.out.println(" \"" + review.getContent() + "\"");
//                System.out.println(" 별점 : " + "★".repeat(review.getRating()) + "☆".repeat(review.getRating()));
//                System.out.println();
//            }
//        }

        // 메뉴 출력
        System.out.println("1. 대출하기\t<- 대출 페이지로 이동");
        System.out.println("2. 리뷰하기\t<- 리뷰 작성 페이지로 이동");
        System.out.println("0. 뒤로가기\t<- 통합 검색 페이지로 이동");
        System.out.print(">>> ");

        // 사용자 입력 처리 - 메뉴 최대값은 2
        int choice = IO.selectMenu(2);
        try {
            choice = Integer.parseInt(System.console().readLine());

            switch (choice) {
                case 0:
                    // 통합 검색 페이지로 이동 코드
                    break;
                case 1:
                    // 대출 기능 구현 예정
                    //borrowBook(book);
                    break;
                case 2:
                    // 리뷰 작성 페이지로 이동 코드
                    break;
            }

        } catch (NumberFormatException e) {
            throw new RuntimeException(e);
        }
    }


}
