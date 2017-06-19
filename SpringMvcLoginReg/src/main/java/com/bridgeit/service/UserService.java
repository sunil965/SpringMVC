package com.bridgeit.service;

import java.util.List;

import com.bridgeit.model.UserRegistrationModel;

public interface UserService {

	public void userRegistration(UserRegistrationModel obj);

	boolean checkExistingEmail(String email);

	public List getAllUsers();
	
	public List getUserById(int id);
	
	public void update(UserRegistrationModel u);
	
	public void deleteUser(int id);
	
	public List userLogin(String email, String pwd);

}
