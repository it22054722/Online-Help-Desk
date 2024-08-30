package com.admin.service;

import java.util.ArrayList;

import com.admin.model.Profile;

public interface IprofileService {

	public void addprofile(Profile profile);
	
	public ArrayList<Profile> getProfile();
	
	public ArrayList<Profile> getProfileById(String profilenumber);
	
	public void UpdateProfile(String profilenumber,Profile profile);
	
	public void DeleteProfile(String profilenumber);
	
	
}
