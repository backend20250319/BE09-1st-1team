# BE09-1st-1team
---
# 유사 프로그램 분석
![Image](https://github.com/user-attachments/assets/e92183c2-f03e-4d98-924d-da0b5b0e1876)

키워드 검색
![Image](https://github.com/user-attachments/assets/83dccda4-394b-4b1e-ac93-419a77512d2e)

상세페이지
![Image](https://github.com/user-attachments/assets/7ee0107d-41e4-46e3-a2ad-2aaafd15adbb)

대출하기 누른 화면
![Image](https://github.com/user-attachments/assets/3ac7c0ab-989e-4e1d-b210-05bfd0cd4d65)

로그인 화면
![Image](https://github.com/user-attachments/assets/c9f0d112-1acf-4516-9201-695d214d2e19)

대출 화면
![Image](https://github.com/user-attachments/assets/71d54b36-dd73-4a8d-84e2-300163c6259c)

## 📋 요구사항 명세서

요구사항은 아래 3장의 이미지로 정리되어 있으며, 주요 항목은 다음과 같습니다:

- 회원 관리: 회원가입, 로그인, 정보 수정
- 도서 관리: 도서 등록, 조회, 검색, 카테고리 분류
- 대출/반납 시스템: 대출 가능 수량 제한, 연령 제한 확인, 연체 처리
- 리뷰 기능: 도서 리뷰 작성 및 조회
- 관리자 기능 (있다면): 도서 관리 및 사용자 정보 접근

📷 상세 명세는 아래 이미지 참조  

![Image](https://github.com/user-attachments/assets/e8a8b571-a382-426b-902c-89ee5a28a365)

![Image](https://github.com/user-attachments/assets/5d0cf156-dc16-4c7f-b586-5e53803c1c75)

![Image](https://github.com/user-attachments/assets/f7048cba-efd1-4ed3-8e51-03e300faa95e)


# 📚 Bookmark Library

콘솔 기반 도서 관리 시스템입니다.  
사용자는 도서를 검색하고, 상세 정보를 조회하며, 리뷰를 작성하거나 도서를 대출할 수 있습니다.

## 🛠 사용 기술

- Java 17
- JDBC (MySQL 연동)
- JUnit 5 (단위 테스트)
- Mockito (테스트용 목 객체

## ✨ 주요 기능

- 🔍 도서 검색 (키워드 기반)
- 📘 도서 상세 정보 확인
- 💬 도서 리뷰 작성 및 조회
- 📥 도서 대출 기능 (로그인 후 사용 가능)
- 🔐 회원 로그인 상태 관리


---
# 📚 BE09-1st-1team - Bookmark Library

콘솔 기반 도서 관리 시스템입니다.

# 🔍 유사 프로그램 분석
도서 검색 및 대출 기능을 가진 기존 서비스들을 참고하여 주요 화면 UI를 정리했습니다.

# ▶️ 실행 방법
1. `MySQL` 서버 실행
2. `application.properties` 또는 `DBUtil.java`에 DB 연결 정보 설정
3. `Main.java` 실행

# 🗃️ 프로젝트 구조
- `view` : 콘솔 UI 페이지들
- `model` : 도서, 회원, 대출, 리뷰 등의 객체
- `dao` : DB 접근 객체
- `service` : 비즈니스 로직
- `util` : 공용 유틸 클래스

## ✨ 주요 기능

- 🔍 도서 검색 (키워드 기반)
- 📘 도서 상세 정보 확인
- 💬 도서 리뷰 작성 및 조회
- 📥 도서 대출 기능 (로그인 후 사용 가능)
- 🔐 회원 로그인 상태 관리

## 🛠 사용 기술

- Java 17
- JDBC (MySQL 연동)
- JUnit 5
- Mockito

## 🗂 데이터베이스 설계 (ERD)
![Image](https://github.com/user-attachments/assets/844a8291-e67c-4f41-9989-d0eebf7bbc4e)

## 🗂 물리 설게


## 🗃️ 프로젝트 구조
...


