package com.BikkadIT.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.BikkadIT.model.Employee;
import com.BikkadIT.service.EmployeeService;

@RestController
public class DeleteController {

	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping(value = "/deleteById/{id}")
	public ResponseEntity<String> delete(@PathVariable int id)
	{
		Employee employee = employeeService.delete(id);
		
		if(employee != null)
		{
			return new ResponseEntity<String>("Data Deleted for Id : "+employee.getEmpId(),HttpStatus.OK);
		}
		
		return new ResponseEntity<String>("Data Can not delete because id is not matching",HttpStatus.OK);

	}
	
	@GetMapping("/deleteAll")
	public ResponseEntity<String> deleteAll()
	{
		employeeService.deleteAll();
		
		return new ResponseEntity<String>("All Employees Data Deleted Successfully",HttpStatus.OK);
	}
}
