package com.BikkadIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeService;

@RestController
public class LoginCheckController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/login",consumes = "application/json",produces = "application/json")
	public ResponseEntity<String> loginCheck(@RequestBody Employee employee)
	{
		Employee employee1 = employeeService.loginCheck(employee.getEmpName(), employee.getEmpId());
		
		if(employee1 != null)
		{
			return new ResponseEntity<String>("successful login",HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("login failed please check Id or Name",HttpStatus.BAD_REQUEST);
	}
}
