package com.bridgeit.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.UserRegistrationModel;
import com.bridgeit.service.UserServiceImpl;

@Controller
@RequestMapping(value = "/")
public class ControllerClass {

	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping(value = "")
	public ModelAndView registeration() {
		return new ModelAndView("registration");
	}

	@RequestMapping(value = "register", method = RequestMethod.POST)
	public ModelAndView insertIntoDb(UserRegistrationModel userRegistrationModel, @RequestParam String email) {
		boolean result = userServiceImpl.checkExistingEmail(email);
		if (result == true) {
			return new ModelAndView("registration", "msg", "This email already exist !!!");
		} else {
			userServiceImpl.userRegistration(userRegistrationModel);
			return new ModelAndView("registration", "msg2", "Registered Successfullly!!!");
		}
	}

	@RequestMapping(value = "/users")
	public ModelAndView usersList() {
		List list = userServiceImpl.getAllUsers();
		return new ModelAndView("userlist", "users", list);
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView find(@PathVariable int id) {
		List u = userServiceImpl.getUserById(id);
		return new ModelAndView("editform", "users", u);
	}

	@RequestMapping(value = "/editsave", method = RequestMethod.POST)
	public ModelAndView editSave(@ModelAttribute("u") UserRegistrationModel u) {
		System.out.println(u.getId());
		System.out.println(u.getName());
		System.out.println(u.getContact());
		System.out.println(u.getEmail());
		System.out.println(u.getPassword());

		userServiceImpl.update(u);
		return new ModelAndView("redirect:users");
	}
}
