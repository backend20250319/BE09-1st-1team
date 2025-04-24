package com.bookmark.library.auth;

import com.bookmark.library.dao.MemberDAO;
import com.bookmark.library.model.Member;

public class LoginContext {
    private static LoginContext loginContext = new LoginContext();

    //private static Member currentUser; //
    private String memberId, password;

    public static boolean login(String memberId, String password) {
        boolean isValid = MemberDAO.validateLogin(memberId, password);
        if (isValid) {
            loginContext.memberId = memberId;
            loginContext.password = password; // 비밀번호도 저장
        }
        return isValid;
    }

    // 현재 로그인한 사용자 정보 가져오기
    public static Member getCurrentUser() {
        if (isLoggedIn()) {
            return (Member) MemberDAO.getUserInfo(loginContext.memberId, loginContext.password); // memberId + password로 조회
        }
        return null;
    }



    // 로그인 여부 확인
    public static boolean isLoggedIn() {
        return loginContext != null;
    }
}
