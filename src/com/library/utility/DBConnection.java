package com.library.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBConnection {

	private static Connection connection = null;
	private static final String DB_DRIVER_CLASS = "DB_DRIVER_CLASS";
	private static final String DB_USERNAME = "DB_USERNAME";
	private static final String DB_PASSWORD = "DB_PASSWORD";
	private static final String DB_URL = "DB_URL";

	private DBConnection() {

	}

	public static Connection getConnection()  {
		if (connection == null) {
			try {
				ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
				InputStream input = classLoader.getResourceAsStream("db.properties");
				Properties properties = new Properties();
				properties.load(input);
				
				Class.forName(properties.getProperty(DB_DRIVER_CLASS));

				connection = DriverManager.getConnection(properties.getProperty(DB_URL),
						properties.getProperty(DB_USERNAME), properties.getProperty(DB_PASSWORD));

			} catch (IOException |ClassNotFoundException| SQLException e) {
				e.printStackTrace();
			}
		}
		return connection;
	}

}
