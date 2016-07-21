package com.bootcamp.utilityservice.dbutil;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author This class provides loads connection details from 
 * properties file to get connection from database
 */
public class DBConnection {

	static Connection con;
	public static Connection getConnection() {
		Properties prop = new Properties();
		InputStream input = null;
		try {

			input = new FileInputStream("C:/Properties File/util.properties");
			// load a properties file
			prop.load(input);
			Class.forName(prop.getProperty("driver"));
			con = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("user"),
					prop.getProperty("password"));
		} 
		catch (IOException | ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
}