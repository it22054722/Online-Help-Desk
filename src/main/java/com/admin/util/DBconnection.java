package com.admin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBconnection extends commonUtil {

	
	 private static Connection connection;
	 
	 private DBconnection(){
		 
		 
	 }
	 
	 public static Connection getDBconnection() throws ClassNotFoundException, SQLException{
		 
		 if (connection == null || connection.isClosed()) {
			 
			 Class.forName(properties.getProperty(commonConstans.DRIVER_NAME));
			 
			 connection = DriverManager.getConnection(properties.getProperty(commonConstans.URL),
					     properties.getProperty(commonConstans.USERNAME), properties.getProperty(commonConstans.PASSWORD));
			 
			 
		 }
		 return connection;
	 }
}
