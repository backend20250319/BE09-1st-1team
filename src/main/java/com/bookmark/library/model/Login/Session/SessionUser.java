package com.bookmark.library.model.Login.Session;

import java.sql.Date;

public class SessionUser {

    private static SessionUser instance;

    private String memberId;
    private String username;
    private Date birthDate;
    private String phone_number;
    private String email;

    private SessionUser() {} // 생성자 private

    public static SessionUser getInstance() {
        if (instance == null) {
            instance = new SessionUser();
        }
        return instance;
    }

    public void setUser(String memberId, String username, Date birthDate, String phone_number,String email) {
        this.memberId = memberId;
        this.username = username;
        this.birthDate = birthDate;
        this.phone_number = phone_number;
        this.email = email;
    }

    public String getMemberId() {
        return memberId;
    }

    public String getUsername() {
        return username;
    }

    public Date getBirthDate() {
        return birthDate;
    }
    public String getPhone_number() {
        return phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void clear() {
        instance = null;
    }
}
