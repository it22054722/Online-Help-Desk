package com.admin.service;

import java.sql.ResultSet;
import java.sql.Statement;

import com.admin.model.adminlogin;
import com.admin.util.dbconnect;

public class adminLoginService {
	
	
	public boolean validate(com.admin.model.adminlogin al) {
		
		try {
			
			String queary = "Select * from add_login where add_email = '"+al.getAdmail()+"' and add_password = '"+al.getAdpassword()+"'";
			
			Statement statment = com.admin.util.dbconnect.getconnection().createStatement();
			
			ResultSet rs = statment.executeQuery(queary);
			
			if(rs.next()) {
				
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return false;
	}

}
