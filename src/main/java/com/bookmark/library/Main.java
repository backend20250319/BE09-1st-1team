package com.bookmark.library;

import com.bookmark.library.view.MainMenuView;

public class Main {
    public static void main(String[] args) {
        var mainMenu = new MainMenuView();
        boolean terminate = false;
        while (!terminate) {
            terminate = !mainMenu.showMainMenu();
        }
    }
}
