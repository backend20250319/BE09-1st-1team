package com.bookmark.library.auth;

import com.bookmark.library.model.Member;

public class LoginContext {

    private static Member currentUser;

    // 로그인 처리
    public static void login(Member member) {
        currentUser = member;
    }

    // 로그아웃 처리
    public static void logout() {
        currentUser = null;
    }

    // 현재 로그인한 사용자 정보 가져오기
    public static Member getCurrentUser() {
        return currentUser;
    }

    // 로그인 여부 확인
    public static boolean isLoggedIn() {
        return currentUser != null;
    }
}
