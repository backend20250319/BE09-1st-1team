package com.bookmark.library.model;

import java.util.Date;
import java.util.List;

public class Book {
    private String isbn;            // 도서번호
    private String title;           // 도서명
    private int categoryId;         // 카테고리 코드
    private String author;          // 저자
    private String publisher;       // 출판사
    private Date publishDate;       // 출판일
    private int stockQuantity;      // 재고수량
    private int totalStock;         // 도서 전체 수량
    private String introduction;    // 한줄소개
    private List<Review> reviews;   // 리뷰
    private int ageLimit;           // 연령제한


    public Book() {}

    public Book(String isbn, String title, int categoryId, String author, String publisher
            , Date publishDate, int stockQuantity, int totalStock
            , String introduction, List<Review> reviews, int ageLimit) {
        this.isbn = isbn;
        this.title = title;
        this.categoryId = categoryId;
        this.author = author;
        this.publisher = publisher;
        this.publishDate = publishDate;
        this.stockQuantity = stockQuantity;
        this.totalStock = totalStock;
        this.introduction = introduction;
        this.reviews = reviews;
        this.ageLimit = ageLimit;
    }

    // getter
    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    public Date getPublishDate() {
        return publishDate;
    }

    public int getStockQuantity() {
        return stockQuantity;
    }

    public int getTotalStock() {
        return totalStock;
    }

    public String getIntroduction() {
        return introduction;
    }

    public int getAgeLimit() {
        return ageLimit;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    // setter
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
    }

    public void setStockQuantity(int stockQuantity) {
        this.stockQuantity = stockQuantity;
    }

    public void setTotalStock(int totalStock) {
        this.totalStock = totalStock;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    // 도서 대출 가능 여부 확인 - 재고수량 확인
    public boolean isAvailable() {
        return stockQuantity > 0;
    }

    // 도서 대출
    public boolean borrowBook() {
        if (isAvailable()) {
            stockQuantity--;
            return true;
        }
        return false;
    }

    // 리뷰 추가
    public void addReview(Review review) {
        reviews.add(review);
    }


    @Override
    public String toString() {
        return "Book{" +
                "isbn='" + isbn + '\'' +
                ", title='" + title + '\'' +
                ", categoryId=" + categoryId +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", publishDate=" + publishDate +
                ", stockQuantity=" + stockQuantity +
                ", totalStock=" + totalStock +
                ", introduction='" + introduction + '\'' +
                ", ageLimit=" + ageLimit +
                '}';
    }
}
