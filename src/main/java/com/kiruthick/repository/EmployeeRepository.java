package com.kiruthick.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.kiruthick.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
	
}
