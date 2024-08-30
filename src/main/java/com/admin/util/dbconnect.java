package com.admin.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnect {

   public static Connection getconnection() throws ClassNotFoundException, SQLException {
	   
	   String username = "root";
	   String password = "Manthi@2001";
	   
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/created_profiles?characterEncoding=utf8",username,password);
	   
	   return con;
   }
}
