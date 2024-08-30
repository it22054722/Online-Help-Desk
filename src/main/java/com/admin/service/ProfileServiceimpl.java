package com.admin.service;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import com.admin.model.Profile;
import com.admin.util.DBconnection;
import com.admin.util.commonConstans;
import com.admin.util.commonUtil;
import com.admin.util.queryUtil;

public class ProfileServiceimpl implements IprofileService{

	private static Connection connection;
	private static Statement stmt;
	private static PreparedStatement preparedStatment;
	
	
	static {
		
		createProfileTable();
	}
	
	
	public static void createProfileTable() {
		
		try {
			connection = DBconnection.getDBconnection();
			
			stmt = connection.createStatement();
			stmt.execute(queryUtil.queryByid(commonConstans.QUERY_ID_CREATE_PROFILE_TABLE));
			
		} catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
		
			System.out.println("create table exception " +e.getMessage());
		}
		finally {
			
			try {
				
				if (connection != null) {
					
					connection.close();
				}
				if(stmt != null) {
					
					stmt.close();
				}
				
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	
	
	@Override
	public void addprofile(Profile profile) {
		
		String profilenumber = commonUtil.generateProfileNumber(getProfilenumbers());
		
		try {
			connection = DBconnection.getDBconnection();
			
			preparedStatment = connection.prepareStatement(queryUtil.queryByid(commonConstans.QUERY_ID_INSERT_PROFILE));
			connection.setAutoCommit(false);
			
			profile.setProfilenumber(profilenumber);
			
			preparedStatment.setString(commonConstans.COLUMN_INDEX_ONE, profile.getProfilenumber());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_TWO, profile.getFullname());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_THREE, profile.getItnumber());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_FOUR, profile.getEmail());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_FIVE, profile.getPhonenumber());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_SIX, profile.getAddress());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_SEVEN, profile.getUsername());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_EIGHT, profile.getPassword());
			
			preparedStatment.executeLargeUpdate();
			connection.commit();
		} 
		catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
   finally {
			
			try {
				
				if (connection != null) {
					
					connection.close();
				}
				if(preparedStatment != null) {
					
					preparedStatment.close();
				}
				
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
	}
	

	@Override
	public ArrayList<Profile> getProfile() {
		
		ArrayList<Profile> profileList = new ArrayList<Profile>();
		
		try {
            connection = DBconnection.getDBconnection();
			
			preparedStatment = connection.prepareStatement(queryUtil.queryByid(commonConstans.QUERY_ID_GET_ALL_PROFILES));
			
			ResultSet rs = preparedStatment.executeQuery();
			
			while(rs.next()) {
				
				Profile pl = new Profile();
				
				pl.setProfilenumber(rs.getString(commonConstans.COLUMN_INDEX_ONE));
				pl.setFullname(rs.getString(commonConstans.COLUMN_INDEX_TWO));
				pl.setItnumber(rs.getString(commonConstans.COLUMN_INDEX_THREE));
				pl.setEmail(rs.getString(commonConstans.COLUMN_INDEX_FOUR));
				pl.setPhonenumber(rs.getString(commonConstans.COLUMN_INDEX_FIVE));
				pl.setAddress(rs.getString(commonConstans.COLUMN_INDEX_SIX));
				pl.setUsername(rs.getString(commonConstans.COLUMN_INDEX_SEVEN));
				pl.setPassword(rs.getString(commonConstans.COLUMN_INDEX_EIGHT));
				
				
				profileList.add(pl);
			}
			
		} 
		catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		 finally {
				
				try {
					
					if (connection != null) {
						
						connection.close();
					}
					if(preparedStatment != null) {
						
						preparedStatment.close();
					}
					
				} 
				catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		return profileList;
		

	}

	@Override
	public ArrayList<Profile> getProfileById(String profilenumber) {
	
     ArrayList<Profile> profileList = new ArrayList<Profile>();
		
		try {
            connection = DBconnection.getDBconnection();
			
			preparedStatment = connection.prepareStatement(queryUtil.queryByid(commonConstans.QUERY_ID_GET_PROFILE_BY_ID));
			
			preparedStatment.setString(commonConstans.COLUMN_INDEX_ONE, profilenumber);
			ResultSet rs = preparedStatment.executeQuery();
			
			while(rs.next()) {
				
				Profile pl = new Profile();
				
				pl.setProfilenumber(rs.getString(commonConstans.COLUMN_INDEX_ONE));
				pl.setFullname(rs.getString(commonConstans.COLUMN_INDEX_TWO));
				pl.setItnumber(rs.getString(commonConstans.COLUMN_INDEX_THREE));
				pl.setEmail(rs.getString(commonConstans.COLUMN_INDEX_FOUR));
				pl.setPhonenumber(rs.getString(commonConstans.COLUMN_INDEX_FIVE));
				pl.setAddress(rs.getString(commonConstans.COLUMN_INDEX_SIX));
				pl.setUsername(rs.getString(commonConstans.COLUMN_INDEX_SEVEN));
				pl.setPassword(rs.getString(commonConstans.COLUMN_INDEX_EIGHT));
				
				
				profileList.add(pl);
			}
			
		} 
		catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
		 finally {
				
				try {
					
					if (connection != null) {
						
						connection.close();
					}
					if(preparedStatment != null) {
						
						preparedStatment.close();
					}
					
				} 
				catch (SQLException e) {
					System.out.println(e.getMessage());
				}
			}
		return profileList;
		
		
	}

	@Override
	public void UpdateProfile(String profilenumber, Profile profile) {
		System.out.println("from inside try at update profile method"+profilenumber);
		
		try {
			connection = DBconnection.getDBconnection();
			
			System.out.println("from inside try at update profile method"+profilenumber);
			
			preparedStatment = connection.prepareStatement(queryUtil.queryByid(commonConstans.QUERY_ID_UPDATE_PROFILE));
			connection.setAutoCommit(false);
			
		
			preparedStatment.setString(commonConstans.COLUMN_INDEX_ONE, profile.getFullname());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_TWO, profile.getItnumber());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_THREE, profile.getEmail());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_FOUR, profile.getPhonenumber());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_FIVE, profile.getAddress());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_SIX, profile.getUsername());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_SEVEN, profile.getPassword());
			preparedStatment.setString(commonConstans.COLUMN_INDEX_EIGHT, profile.getProfilenumber());
			
			preparedStatment.executeLargeUpdate();
			connection.commit();
		} 
		catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
   finally {
			
			try {
				
				if (connection != null) {
					
					connection.close();
				}
				if(preparedStatment != null) {
					
					preparedStatment.close();
				}
				
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
	}

	@Override
	public void DeleteProfile(String profilenumber) {
		
		if(profilenumber != null && !profilenumber.isEmpty()) {
		
			try {
				connection = DBconnection.getDBconnection();
				
				preparedStatment = connection.prepareStatement(queryUtil.queryByid(commonConstans.QUERY_ID_DELETE_PROFILE));
				preparedStatment.setString(commonConstans.COLUMN_INDEX_ONE, profilenumber);
				
				preparedStatment.execute();
				
			} 
			catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
				
				System.out.println(e.getMessage());
			}
		finally {
			
			try {
				
				if (connection != null) {
					
					connection.close();
				}
				if(preparedStatment != null) {
					
					preparedStatment.close();
				}
				
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		}
	}
	
	public ArrayList<String> getProfilenumbers(){
		
		ArrayList<String> num = new ArrayList<String>();
		
		try {
			connection = DBconnection.getDBconnection();
			preparedStatment = connection.prepareStatement(queryUtil.queryByid(commonConstans.QUERY_ID_GET_PROFILE_NUMBERS));
			
			ResultSet rs = preparedStatment.executeQuery();
			
			while(rs.next()) {
				
				num.add(rs.getString(commonConstans.COLUMN_INDEX_ONE));
			}
		} 
		catch (SQLException | SAXException | IOException | ParserConfigurationException | ClassNotFoundException e) {
			
			System.out.println(e.getMessage());
		}
      finally {
			
			try {
				
				if (connection != null) {
					
					connection.close();
				}
				if(preparedStatment != null) {
					
					preparedStatment.close();
				}
				
			} 
			catch (SQLException e) {
				System.out.println(e.getMessage());
			}
		}
		
		return num;
	}

	
}
