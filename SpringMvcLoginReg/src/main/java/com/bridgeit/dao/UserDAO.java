package com.bridgeit.dao;

import java.util.List;

import com.bridgeit.model.UserRegistrationModel;

public interface UserDAO {

	void save(UserRegistrationModel user);

	boolean existEmail(String email);

	List getAllUsersList();
}
