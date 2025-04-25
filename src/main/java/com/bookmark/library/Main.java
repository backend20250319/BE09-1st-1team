package com.bookmark.library;

import com.bookmark.library.dao.BookDAO;
import com.bookmark.library.dao.LoanDAO;
import com.bookmark.library.dao.MemberDAO;
import com.bookmark.library.dao.ReviewDAO;
import com.bookmark.library.service.*;
import com.bookmark.library.view.HomeView;

public class Main {
    public static void main(String[] args) {
        var conn = DB.estabilishConnection();
        Services.register(new LoanService(new LoanDAO(conn)));
        Services.register(new MemberService(new MemberDAO(conn)));
        Services.register(new ReviewService(new ReviewDAO(conn)));
        Services.register(new SearchService(new BookDAO(conn)));

        var homeView = new HomeView();
        homeView.showHome();
    }
}
