---
# 📚 Bookmark Library - BE09-1st-1team

사용자가 도서를 검색하고, 상세 정보를 조회하며, 리뷰를 작성하고 대출할 수 있는 Java 콘솔 애플리케이션입니다.

## 📋 목차
- [프로젝트 개요](#프로젝트-개요)
- [주요 기능](#-주요-기능)
- [기술 스택](#-기술-스택)
- [프로젝트 구조](#-프로젝트-구조)
- [데이터베이스 설계](#-데이터베이스-설계)
- [실행 방법](#-실행-방법)
- [스크린샷](#-스크린샷)
- [참고 자료](#-참고-자료)

## 프로젝트 개요
**프로젝트명**: 책갈피
- **개발 기간**: 2025-04-22 ~ 2025-04-24
- **목표**: Git, MySQL, JDBC, Java 등을 활용하여 데이터베이스와 연동하는 도서관리 시스템 개발
- **팀원** : 이석진 박준범 이주희 박범석

## ✨ 주요 기능
- 🔍 **도서 검색**: 제목, 저자, 출판사 등 키워드 기반 검색
- 📘 **도서 상세 정보**: 도서 정보 및 대출 가능 여부 확인
- 💬 **리뷰 시스템**: 도서 리뷰 작성 및 평점 부여
- 📥 **대출**: 회원 로그인 후 도서 대출 가능
- 👤 **회원 관리**: 로그인, 회원가입, 정보 수정 기능

## 🛠 기술 스택
- **언어**: Java 17
- **데이터베이스**: MySQL
- **DB 연동**: JDBC
- **테스트**: JUnit 5, Mockito
- **버전 관리**: Git, Github

## 🗃️ 프로젝트 구조
```
src/
├── view/      # 콘솔 UI 페이지
├── model/     # 도메인 객체 (도서, 회원, 대출, 리뷰)
├── dao/       # 데이터베이스 접근 객체
├── service/   # 비즈니스 로직
└── util/      # 공용 유틸리티 클래스
```
## 🗂 데이터베이스 설계 

### ERD
![Image](https://github.com/user-attachments/assets/844a8291-e67c-4f41-9989-d0eebf7bbc4e)


### 물리 설계
![Image](https://github.com/user-attachments/assets/0ed6be9a-a11b-4132-bf00-2191fa27e529)


## 📸 스크린샷

### 메인 화면과 도서 검색
![Image](https://github.com/user-attachments/assets/83dccda4-394b-4b1e-ac93-419a77512d2e)

### 도서 상세 정보
![Image](https://github.com/user-attachments/assets/7ee0107d-41e4-46e3-a2ad-2aaafd15adbb)


## 📋 요구사항 명세서

요구사항은 아래 3장의 이미지로 정리되어 있으며, 주요 항목은 다음과 같습니다:

- 회원 관리: 회원가입, 로그인, 정보 수정
- 도서 관리: 도서 등록, 조회, 검색, 카테고리 분류
- 대출/반납 시스템: 대출 가능 수량 제한, 연령 제한 확인, 연체 처리
- 리뷰 기능: 도서 리뷰 작성 및 조회
- 관리자 기능 (있다면): 도서 관리 및 사용자 정보 접근

## 📷 상세 명세는 아래 이미지 참조  

![Image](https://github.com/user-attachments/assets/e8a8b571-a382-426b-902c-89ee5a28a365)

![Image](https://github.com/user-attachments/assets/5d0cf156-dc16-4c7f-b586-5e53803c1c75)

![Image](https://github.com/user-attachments/assets/f7048cba-efd1-4ed3-8e51-03e300faa95e)

## 📑 참고 자료
요구사항 명세서 : [스토리보드](https://docs.google.com/document/d/1dT8QB0bRtqU7c-iLxwGUXjOcIW8KlG4hMT0vT1yrZoU/edit?usp=sharing)


참고 사이트 : [경기도사이버도서관](https://www.library.kr/cyber/)

# ▶️ 실행 방법
1. `MySQL` 서버 실행
2. `application.properties` 또는 `DBUtil.java`에 DB 연결 정보 설정
3. `Main.java` 실행




