package com.bootcamp.utilityservice.dbutil;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;
public class DBConnection {
	static Connection con ;
	
	public static Connection getConnection() {
		
		
		
		Properties prop = new Properties();
		InputStream input = null;

		try {

			input = new FileInputStream("C:/BCJMAY16/Develop/Work Space/Corejava/UtilityService/util.properties");

			// load a properties file
			prop.load(input);

			// load the Driver Class
			Class.forName(prop.getProperty("driver"));

			// create the connection now
			con = DriverManager.getConnection(prop.getProperty("url"),
					prop.getProperty("user"),
					prop.getProperty("password"));
		} catch (IOException | ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return con;
	}
}