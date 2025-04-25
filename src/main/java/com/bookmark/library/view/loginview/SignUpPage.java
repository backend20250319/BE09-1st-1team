package com.bookmark.library.view.loginview;

import com.bookmark.library.service.MemberService;
import com.bookmark.library.service.Services;
import com.bookmark.library.util.IO;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.sql.Date;

public class SignUpPage {
    private final MemberService signUpService = Services.resolve(MemberService.class);

    public void run() {
        System.out.print("""
                ==== BOOKMARK SIGNUP ====
                
                해당 정보를 입력해주세요 !! 
                """);

        // ID 입력
        System.out.print("ID \u001B[31m*\u001B[0m : ");
        String member_id = IO.scanner.nextLine();
        if (member_id.isBlank() || signUpService.isDuplicateId(member_id)) {
            SignUpFailPage.display();
            return;
        }

        // PW 입력
        System.out.print("PW \u001B[31m*\u001B[0m : ");
        String password = IO.scanner.nextLine();
        if (password.isBlank()) {
            SignUpFailPage.display();
            return;
        }

        // 사용자명 입력
        System.out.print("사용자명 \u001B[31m*\u001B[0m : ");
        String username = IO.scanner.nextLine();
        if (username.isBlank()) {
            SignUpFailPage.display();
            return;
        }

        // birth_date 입력
        Date birth_date = null;
        while (true) {
            try {
                System.out.print("생년월일 (yyyy-MM-dd) \u001B[31m*\u001B[0m : ");
                String birthInput = IO.scanner.nextLine();
                if (birthInput.isBlank()) {
                    SignUpFailPage.display();
                    return;
                }
                LocalDate localDate = LocalDate.parse(birthInput);
                birth_date = Date.valueOf(localDate);
                break;
            } catch (DateTimeParseException e) {
                System.out.println("⚠️ 형식이 잘못되었습니다. 예: 1999-04-25");
            }
        }

        System.out.print("전화번호 : ");
        String phone_number = IO.scanner.nextLine();

        System.out.print("이메일 : ");
        String email = IO.scanner.nextLine();

        boolean result = signUpService.saveUser(
                member_id, password, username, birth_date, phone_number, email
        );

        if (result) {
            System.out.println("\n🎉 회원가입이 완료되었습니다!");
            System.out.println("환영합니다, " + username + "님!");
        }
        LoginPage.run();
    }
}