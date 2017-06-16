package com.bridgeit.dao;

import java.util.List;

import com.bridgeit.model.UserRegistrationModel;

public interface UserDAO {

	void save(UserRegistrationModel user);

	boolean existEmail(String email);

	public List getAllUsersList();
	
	public List getUserbyId(int id);

	void update(UserRegistrationModel u);

}
