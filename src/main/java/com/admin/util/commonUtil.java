package com.admin.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class commonUtil {
	
	public static final Properties properties = new  Properties();
	
	static {
		
		try {
			
			properties.load(queryUtil.class.getResourceAsStream(commonConstans.PROPERTY_FILE));
			
		} 
		
		catch (IOException e) {
			
			System.out.println(e.getMessage());
			
		}
	}
	 public static String generateProfileNumber(ArrayList<String>num) {
		  
		  String no;
		  
		  int next = num.size();
		  
		  no = commonConstans.PROFILE_NUMBER_PREFIX + next;
		  
		  if (num.contains(no)) {
			  
			  next++;
			  no = commonConstans.PROFILE_NUMBER_PREFIX + next;
		  }
		  return no;
		  
		  
	  }
	

}
