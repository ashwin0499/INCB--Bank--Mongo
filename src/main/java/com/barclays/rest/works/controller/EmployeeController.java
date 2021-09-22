package com.barclays.rest.works.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.barclays.rest.works.contract.IEmployeeService;
import com.barclays.rest.works.entity.Employee;

@RestController
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String health() {

		return "Welcome!";
	}
	
//	@GetMapping("/dummy-emp")
//	public Employee getDummyEmployee() {
//		return service.dummyEmployee();
//	}
	
	@GetMapping("/sayhi/{name}")
	public String sayHi( @PathVariable("name") String name) {

		return "Hi " + name;
	}

	@GetMapping("/emp")
	public List<Employee> getAllEmployees() {

		return service.getAllEmployees();
	}

	@GetMapping("/emp/{empId}")
	public Employee getEmployee( @PathVariable("empId")  int empId) {

		return service.getEmployeeById(empId);
	}
	
	@PostMapping("/register-emp")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return service.insertEmployee(employee);
	}

	
	@PutMapping("/update-emp")
	public Employee updateEmployee(@RequestBody Employee employee) {

		return service.updateEmployee(employee);
	}

	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId){

		return service.deleteEmployee(empId);
	}
}




