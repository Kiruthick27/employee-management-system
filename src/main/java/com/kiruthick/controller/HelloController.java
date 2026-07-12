package com.kiruthick.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.kiruthick.model.Employee;
import com.kiruthick.service.EmployeeService;

@RestController
@CrossOrigin(origins="http://127.0.0.1:5500")
public class HelloController {
	
	private EmployeeService employeeService;
	
	public HelloController(EmployeeService employeeService) {
		this.employeeService=employeeService;
	}
	@GetMapping("/employee")
	public List<Employee> getEmployee() {
		return employeeService.getEmployee();
		
	}
	
	@PostMapping("/employee")
	public String addEmployee(@RequestBody Employee employee) {
		
		return employeeService.addEmployee(employee);
	}
	
	@PutMapping("/employee/{id}")
	public String updateEmployee(@PathVariable int id ,@RequestBody Employee employee) {
		return employeeService.updateEmployee(id, employee);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public String deleteEmployee(@PathVariable int id) {
		
		return employeeService.deleteEmployee(id);
	}
	
}
