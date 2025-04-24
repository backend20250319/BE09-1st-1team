package com.bookmark.library;

import com.bookmark.library.dao.LoanDAO;
import com.bookmark.library.util.DBUtil;
import com.bookmark.library.view.HomeView;

public class Main {
    public static void main(String[] args) {
        var connection = DBUtil.getConnection();
        var loanDAO = new LoanDAO(connection);
        var homeView = new HomeView(loanDAO);
        homeView.showHome();
    }
}
