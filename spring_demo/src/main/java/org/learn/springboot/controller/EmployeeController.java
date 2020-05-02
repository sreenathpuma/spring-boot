package org.learn.springboot.controller;

import java.util.List;

import org.learn.springboot.entity.Employee;
import org.learn.springboot.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	//methods
	@GetMapping("/employee")
	private List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	@GetMapping("/employee/{id}")
	private Employee getEmployee(@PathVariable("id") int id) {
		return employeeService.getEmployeeById(id);
	}
	@DeleteMapping("/employee/{id}")
	private void deleteEmployee(@PathVariable("id") int id) {
		employeeService.delete(id);
	}
	@PostMapping("/employees")
	private int save(@RequestBody Employee emp) {
		employeeService.saveOrUpdate(emp);
		return emp.getId();
	}
	@PutMapping("/employees")
	private Employee update(@RequestBody Employee emp) {
		employeeService.saveOrUpdate(emp);
		return emp;
	}
}
