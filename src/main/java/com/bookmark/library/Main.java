package com.bookmark.library;

import com.bookmark.library.util.DBUtil;
import com.bookmark.library.view.MainMenuView;

public class Main {
    public static void main(String[] args) {
        var connection = DBUtil.getConnection();

        var mainMenu = new MainMenuView();
        boolean terminate = false;
        while (!terminate) {
            terminate = !mainMenu.showMainMenu();
        }
    }
}
