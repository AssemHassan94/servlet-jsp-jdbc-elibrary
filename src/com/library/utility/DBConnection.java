package com.library.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

    private static Connection connection = null;

    private DBConnection() {

    }

    public static Connection getConnection() {
        if (connection == null) {
            try {
                Properties properties = new Properties();

                FileInputStream propertiesFile = new FileInputStream("D:\\One drive\\OneDrive\\Desktop\\eLibrary\\db.properties");
                properties.load(propertiesFile);
                Class.forName(properties.getProperty("DB_DRIVER_CLASS"));
                connection = DriverManager.getConnection(properties.getProperty("DB_URL"), properties.getProperty("DB_USERNAME"), properties.getProperty("DB_PASSWORD"));
            } catch (IOException | ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        }
        return connection;
    }

}
