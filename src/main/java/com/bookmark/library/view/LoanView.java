package com.bookmark.library.view;

import com.bookmark.library.exception.LoanFailureException;
import com.bookmark.library.exception.ReturnToHomeException;
import com.bookmark.library.model.Book;
import com.bookmark.library.common.LoanFailureReason;
import com.bookmark.library.model.Member;
import com.bookmark.library.service.LoanService;
import com.bookmark.library.util.IO;

import java.time.LocalDate;

/**
 * 도서 대출 페이지 뷰
 */
public class LoanView {
    private static final int LOAN_DURATION_DAYS = 7;

    private final LoanService loanService;

    public LoanView(LoanService loanService) {
        this.loanService = loanService;
    }

    public void showLoanPage(Book book) {
        Member member = null; // TODO: LoginContext에서 얻어와야 함
        member = new Member(); // 테스트용 임시객체

        if (member == null) {
            loginRequired();
            return;
        }

        var reason = loanService.canLoan(member, book);
        if (reason != null) {
            showNotAvailable(reason);
            return;
        }

        LocalDate dueDate = LocalDate.now().plusDays(LOAN_DURATION_DAYS);
        int maxCount = LoanService.MAX_LOAN_COUNT;
        int current = loanService.getLoanCount(member.getId());
        int remaining = maxCount - current;
        System.out.println("반납 예정일: " + dueDate);
        System.out.println("현재 " + remaining + "권까지 더 대출하실 수 있습니다. (최대 " + maxCount + "권까지 대출 가능)");
        if (IO.confirm("[" + book.getTitle() + "] 대출하시겠습니까?")) {
            try {
                loanService.loanBook(member, book);
                System.out.println("대출이 완료되었습니다.");
                IO.pressEnterToProceed();
            } catch (LoanFailureException e) {
                showNotAvailable(e.getReason());
            }
        }
    }

    private void loginRequired() {
        System.out.print("""
                로그인이 필요합니다.
                1. 홈으로
                0. 뒤로
                """);
        if (IO.selectMenu(1) == 1) {
            throw new ReturnToHomeException();
        }
    }

    private void showNotAvailable(LoanFailureReason reason) {
        System.out.println("대출이 불가능합니다.");
        System.out.println(reason.getMessage());
        IO.pressEnterToProceed();
    }
}
