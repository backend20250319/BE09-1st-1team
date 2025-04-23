package com.bookmark.library.model.UserInfo.Main;

import com.bookmark.library.model.Login.Session.SessionUser;
import com.bookmark.library.model.UserInfo.Service.UserEditService;
import com.bookmark.library.util.IO;

public class InfoEditPage {
    public static void run() {

        System.out.println("""
                ==== BOOKMARK ====
                개인정보 수정
                """);

        System.out.print("비밀번호  : ");
        String password = IO.scanner.nextLine();

        System.out.print("사용자명  : ");
        String username = IO.scanner.nextLine();

        System.out.print("전화번호  : ");
        String phone_number = IO.scanner.nextLine();

        System.out.print("이메일    : ");
        String email = IO.scanner.nextLine();

        SessionUser session = SessionUser.getInstance();

        boolean result = UserEditService.updateUser(
                session.getMemberId(),
                password,
                username,
                phone_number,
                email
        );

        if (result) {
            System.out.println("\n✅ 개인정보가 성공적으로 수정되었습니다!");
        } else {
            System.out.println("\n❌ 수정에 실패했습니다. 다시 시도해주세요.");
            return;
        }

        UserInfoPage.run();
    }
}
