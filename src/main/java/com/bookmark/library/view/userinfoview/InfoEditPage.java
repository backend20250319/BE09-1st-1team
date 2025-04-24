package com.bookmark.library.view.userinfoview;

import com.bookmark.library.auth.Session.SessionUser;
import com.bookmark.library.service.UserEditService;
import com.bookmark.library.util.IO;

public class InfoEditPage {
    public static void run() {
        System.out.println("""
                
                ==== BOOKMARK ====
                ✏️ 개인정보 수정
                """);

        SessionUser session = SessionUser.getInstance();
        String memberId = session.getMemberId();

        String password;
        while (true) {
            System.out.print("새 비밀번호 \u001B[31m*\u001B[0m : ");
            password = IO.scanner.nextLine().trim();
            if (!password.isBlank()) break;
            System.out.println("⚠️ 비밀번호는 필수 입력 항목입니다. 다시 입력해주세요.");
        }

        String username;
        while (true) {
            System.out.print("새 사용자명 \u001B[31m*\u001B[0m : ");
            username = IO.scanner.nextLine().trim();
            if (!username.isBlank()) break;
            System.out.println("⚠️ 사용자명은 필수 입력 항목입니다. 다시 입력해주세요.");
        }

        System.out.print("새 전화번호: ");
        String phoneNumber = IO.scanner.nextLine();

        System.out.print("새 이메일: ");
        String email = IO.scanner.nextLine();

        boolean result = UserEditService.updateUser(
                memberId,
                password,
                username,
                phoneNumber,
                email
        );

        if (result) {
            System.out.println("\n✅ 개인정보가 성공적으로 수정되었습니다!");
        } else {
            System.out.println("\n❌ 수정에 실패했습니다. 다시 시도해주세요.");
        }
    }
}
