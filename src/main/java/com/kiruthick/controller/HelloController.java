package com.kiruthick.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
	public ResponseEntity<List<Employee>> getEmployee() {
		
		List<Employee> employee=employeeService.getEmployee();
		return ResponseEntity.ok(employee);
		
	}
	
	@PostMapping("/employee")
	public ResponseEntity<String> addEmployee(@RequestBody Employee employee) {
		
		String message= employeeService.addEmployee(employee);
		return ResponseEntity.status(HttpStatus.CREATED).body(message);
		
	}
	
	@PutMapping("/employee/{id}")
	public ResponseEntity<String> updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
		
		String message=employeeService.updateEmployee(id,employee);
		return ResponseEntity.ok(message);
		
	}
	
	@DeleteMapping("/employee/{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
		
		String message=employeeService.deleteEmployee(id);
		return ResponseEntity.ok(message);
	}
	
}
