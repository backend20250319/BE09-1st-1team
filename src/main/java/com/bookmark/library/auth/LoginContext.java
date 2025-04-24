package com.bookmark.library.auth;

import com.bookmark.library.dao.MemberDAO;
import com.bookmark.library.model.Member;

public class LoginContext {
    private static LoginContext loginContext = new LoginContext();

    private String memberId;
    private String password;

    // 로그인 처리
    public static boolean login(String memberId, String password) {
        boolean isValid = MemberDAO.validateLogin(memberId, password);
        if (isValid) {
            loginContext.memberId = memberId;
            loginContext.password = password;
        }
        return isValid;
    }

    // 로그아웃 처리
    public static void logout() {
        loginContext = null;
    }

    // 현재 로그인한 사용자 정보 가져오기
    public static Member getCurrentUser() {
        if (isLoggedIn()) {
            return MemberDAO.getUserInfo(loginContext.memberId, loginContext.password); // Member 객체 반환
        }
        return null;
    }

    // 로그인 여부 확인
    public static boolean isLoggedIn() {
        return loginContext != null && loginContext.memberId != null;
    }
}
