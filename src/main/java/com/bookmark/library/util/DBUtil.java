package com.bookmark.library.util;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {
    public static Connection getConnection() {
        String home = System.getProperty("user.home");
        String dbPath = home + "/.bookmark/db.properties";

        Properties properties = new Properties();
        try {
            properties.load(new FileReader(dbPath));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String url = properties.getProperty("url");
        try {
            return DriverManager.getConnection(url, properties);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
