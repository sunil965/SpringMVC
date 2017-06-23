package com.bridgeit.errorhandling;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RegistrationController {

/*	@ModelAttribute("professionList")
	public List<String> populateProfessionList()
	{
		List<String> professionList = new ArrayList<String>(); 
		professionList.add("Devloper");
		professionList.add("Manager");
		professionList.add("Architecht");
		
		return professionList;
	}
	@ModelAttribute("hobbyList")
	public List<String> populateHobbyList()
	{
		List<String> hobbyList = new ArrayList<String>(); 
		hobbyList.add("Cricket");
		hobbyList.add("Football");
		hobbyList.add("Hockey");
		hobbyList.add("Basketball");
		
		return hobbyList;
	}*/
	@RequestMapping("/displayForm")
	public String displayForm(Map<String, RegistrationBean> model)
	{
		RegistrationBean rb = new RegistrationBean();
		model.put("rb",rb);
		return "registrationForm";
	}
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String processRegistration(@ModelAttribute("rb") RegistrationBean rb) throws IOException
	{
		if(rb.getFirstName().length()>5 || rb.getLastName().length()>5)
		{
			throw new IOException("IOException has occured");
		}
		return "success";
	}
	@ExceptionHandler(IOException.class)
	public ModelAndView  processException(IOException ioe)
	{
		String name = ioe.getClass().getSimpleName();
		String message = ioe.getMessage();
		/*ModelAndView mav = new ModelAndView("exceptionPage");
		 mav.addObject("name", ioe.getClass().getSimpleName());
	     mav.addObject("message", ioe.getMessage());*/
	 
	     return new ModelAndView("exceptionPage", name, message);
	}
}
