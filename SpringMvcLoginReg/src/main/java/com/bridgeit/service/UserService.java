package com.bridgeit.service;

import java.util.List;

import com.bridgeit.model.UserRegistrationModel;

public interface UserService {

	public void userRegistration(UserRegistrationModel obj);

	boolean checkExistingEmail(String email);

	List getAllUsers();

}
