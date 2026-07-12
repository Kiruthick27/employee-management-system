package com.kiruthick.service;


import java.util.List;

import org.springframework.stereotype.Service;

import com.kiruthick.model.Employee;
import com.kiruthick.repository.EmployeeRepository;

@Service
public class EmployeeService {
	
	private EmployeeRepository employeeRepository;
	
	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
	
	public List<Employee> getEmployee(){
		return employeeRepository.findAll();
	}
	public String addEmployee(Employee employee) {
	    employeeRepository.save(employee);
	    return "Employee Added Successfully";
	}

	public String updateEmployee(int id, Employee employee) {
		
		if(employeeRepository.existsById(id)) {
			
			employee.setId(id);
			employeeRepository.save(employee);
			return "Employee Updated Successfully";
		}
		else {
			
			return "Employee Not Found";
			
		}
	}

	public String deleteEmployee(int id) {
		
		if(employeeRepository.existsById(id)) {
			
			employeeRepository.deleteById(id);
			
			return "Employee Deleted Successfully";
		}else {
			
			return "Employee Not Found";
			
		}

	}
	
}
