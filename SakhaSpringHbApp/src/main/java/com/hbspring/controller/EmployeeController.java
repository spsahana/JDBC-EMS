package com.hbspring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hbspring.model.*;
import com.hbspring.service.EmployeeService;





@Controller
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	@PostMapping("/add")
	public String addEmployee(@ModelAttribute Employee emp,Model m) {
		String msg="Failed....";
		if(service.saveEmployee(emp))
			msg="Successful...";
		m.addAttribute("msg",msg);
		return "view.jsp";
	}
	
	
	@PostMapping("/display")
	public String getEmployee(@RequestParam("empId") int empId,Model m) {
		Employee emp=service.getEmployee(empId);
		m.addAttribute("emp",emp);
		return "viewemp.jsp";
	}

	@GetMapping("/employees")
	public String getAllEmployees(Model m) {
		List<Employee> empList=service.getAllEmloyees();
		m.addAttribute("empList",empList);
		return "viewall.jsp";
	}
	
	@PostMapping("/del")
	public String deleteEmp(@RequestParam("empId") int empId,Model m) {
		
		String msg="Failed....";
		Employee emp = service.getEmployee(empId);
		if(service.deleteEmployee(emp))
			msg="Successful...";
		m.addAttribute("msg",msg);
		return "view.jsp";
	}
	
	
}
