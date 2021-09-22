package com.barclays.rest.works.controller;

import java.util.List;

import com.barclays.rest.works.entity.Account;
import com.barclays.rest.works.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.barclays.rest.works.contract.IEmployeeService;
import com.barclays.rest.works.entity.Employee;

@RestController
//@RequestMapping("/api")
public class EmployeeController {

	@Autowired
	private IEmployeeService service;
	
	@GetMapping("/")
	public String welcome() {

		return "Welcome User!";
	}
	
//	@GetMapping("/dummy-emp")
//	public Employee getDummyEmployee() {
//		return service.dummyEmployee();
//	}
	
	@GetMapping("/sayhi/{name}")
	public String sayHi( @PathVariable("name") String name) {

		return "Hi " + name;
	}

	@PostMapping("/login")
	public Employee verifyacholder (@RequestBody Employee employee)
	{
		return service.verifyacholder(employee.empId);
	}

	@GetMapping("/emp")
	public List<Employee> getAllEmployees() {

		return service.getAllEmployees();
	}

	@GetMapping("/emp/{empId}")
	public Employee getEmployee( @PathVariable("empId")  int empId) {

		return service.getEmployeeById(empId);
	}

	@GetMapping("/emp/account/{accId}")
	public Employee findByAccId(@PathVariable("accId") int accId){
		return service.findByAccID(accId);
	}

	@PostMapping("/register-emp")
	public Employee saveEmployee(@RequestBody Employee employee) {

		return service.insertEmployee(employee);
	}

	@PutMapping("/update-employees")
	public Employee updateEmployee(@RequestBody Employee employee) {

//		Query query = new Query();
//		query.addCriteria(Criteria.where("id").is(employee.getEmpId()));
//		Update update = new Update();
//		update.set("name", employee.getEmpName());
//		update.set("2000", employee.getSalary());
//		return mongoTemplate.findAndModify(query, update, Employee.class);
		return null;
	}

	@DeleteMapping("/delete/{empId}")
	public String deleteEmployee(@PathVariable("empId") int empId){

		return service.deleteEmployee(empId);
	}

	@PutMapping("/update/account/{empId}")
	public ResponseEntity<?> update(@RequestBody Account account,@PathVariable("empId") int empId) {
		Employee updatedAccount = service.updateAccount(account,empId);
		return ResponseEntity.ok().body(updatedAccount);
	}
}




