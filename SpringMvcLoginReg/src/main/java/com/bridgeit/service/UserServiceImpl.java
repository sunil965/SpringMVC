package com.bridgeit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.bridgeit.dao.UserDAO;
import com.bridgeit.model.UserRegistrationModel;

@Service
@Component
public class UserServiceImpl implements UserService {
	@Autowired
	UserDAO daoObject;

	@Override
	public void userRegistration(UserRegistrationModel user) {
		daoObject.save(user);
	}

	@Override
	public boolean checkExistingEmail(String email) {
		boolean result = daoObject.existEmail(email);
		return result;
	}

	@Override
	public List getAllUsers() {
		return daoObject.getAllUsersList();
	}

	@Override
	public List getUserById(int id) {
		return daoObject.getUserbyId(id);
	}

	@Override
	public void update(UserRegistrationModel u) {
		daoObject.update(u);
	}

}
