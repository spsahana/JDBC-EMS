package com.hbspring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hbspring.model.Employee;
import com.hbspring.repository.EmployeeRepo;

@Service
public class EmployeeService {
	@Autowired
	EmployeeRepo repo;
	public boolean saveEmployee(Employee emp) {
		return repo.saveEmployee(emp);
	}
	
	public Employee getEmployee(int empId) {
		return repo.getEmployee(empId);
	}
	
	public boolean deleteEmployee(Employee emp) {
		return repo.deleteEmployee(emp);
	}
	
	public List<Employee> getAllEmloyees(){
		return repo.getAllEmployee();
	}

}
