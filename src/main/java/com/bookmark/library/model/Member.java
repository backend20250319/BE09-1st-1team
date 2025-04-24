package com.bookmark.library.model;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Date;

public class Member {
    private String id;              // 사용자 id
    private String password;        // 비밀번호
    private String username;        // 사용자 이름
    private Date birthDate;         // 생년월일
    private String phoneNumber;     // 전화번호
    private String email;           // 이메일

    public Member() {}

    public Member(String id, String password, String username
            , Date birthDate, String phoneNumber, String email) {
        this.id = id;
        this.password = password;
        this.username = username;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // getter
    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    // setter
    public void setId(String id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getAge() {
        // birthDate(Date)를 LocalDate로 전환 - 생년월일로 나이 계산
        LocalDate birthLocalDate = this.birthDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        // 현재 날짜
        LocalDate now = LocalDate.now();

        // 나이 계산
        return Period.between(birthLocalDate, now).getYears();
    }

    @Override
    public String toString() {
        return "Member{" +
                "id='" + id + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", birthDate=" + birthDate +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
