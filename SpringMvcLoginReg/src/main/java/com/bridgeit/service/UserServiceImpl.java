package com.bridgeit.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bridgeit.dao.UserDAO;
import com.bridgeit.model.UserRegistrationModel;

@Service
@Transactional
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDAO daoObject;

	public void userRegistration(UserRegistrationModel user) {
		daoObject.save(user);
	}

	@Transactional(readOnly=true)
	public boolean checkExistingEmail(String email) {
		boolean result = daoObject.existEmail(email);
		return result;
	}

	@Transactional(readOnly=true)
	public List getAllUsers() {
		return daoObject.getAllUsersList();
	}

	@Transactional(readOnly=true)
	public List getUserById(int id) {
		return daoObject.getUserbyId(id);
	}

	public void update(UserRegistrationModel u) {
		daoObject.update(u);
	}

	public void deleteUser(int id) {
		daoObject.deleteUser(id);
	}

	@Transactional(readOnly=false)
	public List userLogin(String email, String pwd) {
		return daoObject.loginUser(email, pwd);
	}

}
