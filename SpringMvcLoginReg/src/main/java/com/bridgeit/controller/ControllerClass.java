package com.bridgeit.controller;

import java.util.Iterator;
import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bridgeit.model.UserRegistrationModel;
import com.bridgeit.service.UserServiceImpl;

@Controller
public class ControllerClass {
	// Instantiating log4j
	private static final Logger logger = Logger.getLogger(ControllerClass.class);

	@Autowired
	UserServiceImpl userServiceImpl;

	@RequestMapping(value = "/")
	public ModelAndView registeration() {
		ModelAndView mv = new ModelAndView("login");
		return mv;
	}

	@RequestMapping("/login")
	public ModelAndView login(UserRegistrationModel registrationModel) {

		ModelAndView view = null;

		List list = userServiceImpl.userLogin(registrationModel.getEmail(), registrationModel.getPassword());
		if (list.size() != 0) {
			Iterator userIterator = list.iterator();
			while (userIterator.hasNext()) {
				UserRegistrationModel u = (UserRegistrationModel) userIterator.next();
				int id = u.getId();
			}

			view = new ModelAndView("registration", "registrationModel", new UserRegistrationModel());
			return view;
		}
		view = new ModelAndView("login", "msg", "invalid credential.....");
		return view;
	}

	@RequestMapping(value = "welcome")
	public ModelAndView redirect() {
		return new ModelAndView("registration","registrationModel", new UserRegistrationModel());
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView insertIntoDb(@ModelAttribute("registrationModel") @Valid UserRegistrationModel registrationModel, BindingResult res,
			@RequestParam String email) {
		
		if(logger.isDebugEnabled()){
			logger.debug("registration is executed! by log4j");
		}
		logger.error("This is Error message", new Exception("Testing"));

//		System.out.println(res);
		if (res.hasErrors()) {
			return new ModelAndView("registration","registrationModel", registrationModel);
		} else {
			boolean result = userServiceImpl.checkExistingEmail(email);
			if (result == true) {
				return new ModelAndView("registration", "msg", "This email already exist !!!");
			} else {
				userServiceImpl.userRegistration(registrationModel);
				ModelAndView mv=new ModelAndView("redirect:users");
				//mv.addObject("msg2","Registration successfull......");
				return mv;
			}
		}
	}

	@RequestMapping(value = "/users")
	public ModelAndView usersList() {
		List list = userServiceImpl.getAllUsers();
		return new ModelAndView("userlist", "users", list);
	}

	@RequestMapping(value = "/edit/{id}")
	public ModelAndView find(@PathVariable("id") int id) {
		System.out.println(id);
		List u = userServiceImpl.getUserById(id);
		return new ModelAndView("editform", "users", u);
	}

	@RequestMapping(value = "/editsave")
	public ModelAndView editSave(UserRegistrationModel u) {
		userServiceImpl.update(u);
		return new ModelAndView("redirect:users");
	}

	@RequestMapping(value = "/delete")
	public ModelAndView delete(@RequestParam("id") int id) {
		userServiceImpl.deleteUser(id);
		return new ModelAndView("redirect:users");
	}
}
