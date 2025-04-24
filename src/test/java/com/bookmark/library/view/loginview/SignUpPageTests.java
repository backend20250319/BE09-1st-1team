package com.bookmark.library.view.loginview;

import com.bookmark.library.service.SignUpService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;

public class SignUpPageTests {

    @Test
    public void testSignUp_Success() {
        // given
        String id = "testuser123"; // 매번 유니크한 ID로 테스트하거나 DB 클린업
        String pw = "testpass";
        String name = "테스트사용자";
        Date birth = Date.valueOf(LocalDate.of(1995, 5, 15));
        String phone = "010-1234-5678";
        String email = "test123@example.com";

        // when
        boolean result = SignUpService.saveUser(id, pw, name, birth, phone, email);

        // then
        Assertions.assertTrue(result, "회원가입에 실패했습니다.");
    }

    @Test
    public void testSignUp_Fail_DuplicateId() {
        // given
        String id = "1234"; // DB에 이미 존재하는 ID여야 함
        String pw = "pass";
        String name = "중복사용자";
        Date birth = Date.valueOf("1990-01-01");
        String phone = "010-0000-0000";
        String email = "dupe@example.com";

        // when
        boolean result = SignUpService.saveUser(id, pw, name, birth, phone, email);

        // then
        Assertions.assertFalse(result, "중복된 ID로 가입되면 안 됩니다.");
    }

    @Test
    public void testIsDuplicateId() {
        // 가정: "admin"은 이미 가입된 ID
        Assertions.assertTrue(SignUpService.isDuplicateId("admin"), "이미 존재하는 ID임에도 중복 검사에 실패했습니다.");
        Assertions.assertFalse(SignUpService.isDuplicateId("thisidshouldnotexist"), "존재하지 않는 ID인데 중복으로 판별되었습니다.");
    }
}
