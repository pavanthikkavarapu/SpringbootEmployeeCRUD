package com.goal.student.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.goal.student.demo.entity.Employee;
import com.goal.student.demo.repository.EmployeeRepo;


@RestController
public class EmployeeController {
	
	@Autowired
	EmployeeRepo employeeRepo;
	
	@GetMapping("/employeeList")
	public List<Employee> getEmployeeList() {
		
		return employeeRepo.findAll();
	}
	@GetMapping("employee/{id}")
	public Employee getEmployee(@PathVariable int id) {
		return employeeRepo.findById(id).get();
	}
	
	@DeleteMapping("employee/delete/{id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void removeEmployee(@PathVariable int id) {
		Employee emp = employeeRepo.findById(id).get();
		employeeRepo.delete(emp);
		
		
	}
	
	
	@PutMapping("employee/update/{id}")
	public Employee updateEmployee(@PathVariable int id) {
		Employee emp = employeeRepo.findById(id).get();
		emp.setFirstName("poonam");
		emp.setAge(24);
		employeeRepo.save(emp);
		return emp;
		
	}
	
//	get, post, update, delete
	
	@PostMapping("/Employee/add")
	public Employee createEmployee(@RequestBody Employee emp) {
		employeeRepo.save(emp);
		return emp;
		
	}
}
