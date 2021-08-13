package com.manish.SampleSpringProject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manish.SampleSpringProject.service.EmployeeService;
import com.manish.SampleSpringProject.model.Employee;
import com.manish.SampleSpringProject.model.MessageResponse;
import com.manish.SampleSpringProject.model.Response;
import com.manish.SampleSpringProject.model.DataResponse;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping("/")
	public ResponseEntity<Response> getAllEmployee() {
		
		List<Employee> allEmployees = employeeService.getAllEmployee();
		
		Response response = new DataResponse<List<Employee>>(true, allEmployees);
		
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Sample Header");
		
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(response);
		
	}
	
	@PostMapping("/add")
	public ResponseEntity<Response> addEmployee(@RequestBody Employee employee) {
		
		employeeService.addEmployee(employee);
		
		Response response = new MessageResponse(true, "Successfully Added.");
		
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Sample Header");
		
		return ResponseEntity.status(HttpStatus.OK).headers(header).body(response);
		
	}
	
	@PostMapping("/find")
	public ResponseEntity<Response> findEmployeeById(@RequestBody Employee t) {
		
		Employee employee = employeeService.findEmployeeById(t.getEid()); 
		
		HttpHeaders header = new HttpHeaders();
		header.add("desc", "Sample Header");
		
		if(employee == null)
			return ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.headers(header)
					.body(new MessageResponse(false, "No Such Employee"));
		else
			return ResponseEntity.status(HttpStatus.OK)
					.headers(header)
					.body(new DataResponse<Employee>(true, employee));
	}
}
