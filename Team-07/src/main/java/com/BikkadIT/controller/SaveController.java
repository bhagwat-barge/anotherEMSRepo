package com.BikkadIT.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeService;

@RestController
public class SaveController {

	@Autowired
	private EmployeeService employeeService;
	
	@PostMapping(value = "/save",produces = "application/json",consumes = "application/json")
	public ResponseEntity<String> saveEmployee(@RequestBody Employee employee)
	{
		Employee employee1 = employeeService.saveEmployee(employee);
		
		return new ResponseEntity<String>("Employee Data Saved With Id and Name: "+employee1.getEmpId()+"---"+employee1.getEmpName(), HttpStatus.OK);
	}
	
	@PostMapping(value = "/saveMultiple",produces = "application/json",consumes = "application/json")
	public ResponseEntity<List<String>> saveMultiEmployee(@RequestBody List<Employee> employees)
	{
		 List<String> multiEmployee = employeeService.saveMultiEmployee(employees);
		
		return new ResponseEntity<List<String>>(multiEmployee, HttpStatus.OK);
	}
}
