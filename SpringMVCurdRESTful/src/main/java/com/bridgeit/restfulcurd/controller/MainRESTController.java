package com.bridgeit.restfulcurd.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.restfulcurd.dao.EmployeeDAO;
import com.bridgeit.restfulcurd.model.Employee;

@RestController
public class MainRESTController {

	@Autowired
	EmployeeDAO employeeDAO;

	@RequestMapping("/")
	public String welcome() {
		return "Restful Crud ki taraf pahla kadam !! :)";
	}

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Employee> getEmployees() {
		List<Employee> list = employeeDAO.getAllEmployees();
		return list;
	}

	@RequestMapping(value = "/employees/{empNo}", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public Employee getEmployee(@PathVariable("empNo") String empNo) {
		return employeeDAO.getEmployee(empNo);
	}

	@RequestMapping(value = "/addemp", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
//	@PostMapping("/addemp")
	public Employee addEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getEmpName() + " added");
		return employeeDAO.addEmployee(emp);
	}

	@RequestMapping(value = "/updateemp", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Employee updateEmployee(@RequestBody Employee emp) {
		System.out.println(emp.getEmpName() + " updated");
		return employeeDAO.updateEmployee(emp);
	}

	// URL:
	// http://localhost:8080/SpringMVCRESTful/employees/{empNo}
	@RequestMapping(value = "/deletreemp/{empNo}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public void deleteEmployee(@PathVariable("empNo") String empNo) {
		employeeDAO.deleteEmployee(empNo);
	}
}
