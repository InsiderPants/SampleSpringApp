package com.manish.SampleSpringProject.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.manish.SampleSpringProject.model.Employee;

@Service
public class EmployeeService {
	private List<Employee> allEmployee;
	
	EmployeeService() {
		this.allEmployee = new ArrayList<Employee>();
		
		for(int i = 1; i <= 4; i++)
			allEmployee.add(new Employee(i, "name" + i, i * 100.0));
	}
	
	public List<Employee> getAllEmployee() {
		return allEmployee;
	}
	
	public void addEmployee(Employee employee) {
		allEmployee.add(employee);
	}
	
	public Employee findEmployeeById(int eid) {
		for(Employee employee : allEmployee)
			if(employee.getEid() == eid)
				return employee;
		return null;
	}
	
}
