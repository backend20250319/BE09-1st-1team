package com.bookmark.library.util;

import java.util.InputMismatchException;
import java.util.Scanner;

public class IO {
    public static final Scanner scanner = new Scanner(System.in);

    public static int readIntLine() {
        int n = scanner.nextInt();
        scanner.nextLine();
        return n;
    }

    /**
     * 사용자로부터 메뉴 선택 번호를 입력받습니다.
     * 유효하지 않은 번호가 입력되면 재입력을 요구합니다.
     * @param max 유효한 메뉴 번호의 최대값
     * @return 입력된 메뉴 번호
     */
    public static int selectMenu(int max) {
        while (true) {
            System.out.print(">>> ");
            try {
                int menu = readIntLine();
                if (0 <= menu && menu <= max) {
                    return menu;
                }
            } catch (RuntimeException e) {
                scanner.nextLine(); // 입력 버퍼에 남은 잘못된 문자열 제거
            }
        }
    }

    public static boolean confirm(String message) {
        System.out.print(message + " (y/n) ");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("y");
    }

    public static void pressEnterToProceed() {
        System.out.print("\n(확인: ENTER)");
        scanner.nextLine();
    }


}
