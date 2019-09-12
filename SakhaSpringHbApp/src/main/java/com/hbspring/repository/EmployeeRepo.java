package com.hbspring.repository;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.hbspring.model.Employee;

@Repository
public class EmployeeRepo {
	
	@Autowired
	SessionFactory sf;
	@Transactional
	public boolean saveEmployee(Employee emp) {
		Session ssn=sf.openSession();
//		Transaction tx=ssn.beginTransaction();
		
		ssn.save(emp);
		return true;
	}
	
	@Transactional
	public Employee getEmployee(int empId) {
		Session ssn=sf.openSession();
		return ssn.get(Employee.class,empId);
	}
	
	
	@Transactional
	public List<Employee> getAllEmployee(){
		Session ssn=sf.openSession();
		Criteria ctr=ssn.createCriteria(Employee.class);
		return ctr.list();
	}
	
	@Transactional
	public boolean deleteEmployee(Employee emp) {
		Session ssn=sf.getCurrentSession();
		
		ssn.delete(emp);
		return true;
	}
	
	
	
}
