package org.learn.springboot.service;

import java.util.ArrayList;
import java.util.List;

import org.learn.springboot.entity.Employee;
import org.learn.springboot.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

	@Autowired
	EmployeeRepository employeeRepository;
	
	public List<Employee> getAllEmployees(){
		List<Employee>lst = new ArrayList<Employee>();
		employeeRepository.findAll().forEach(emp->lst.add(emp));
		return lst;
	}
	public Employee getEmployeeById(int id) {
		return employeeRepository.findById(id).get();
	}
	public void saveOrUpdate(Employee emp) {
		employeeRepository.save(emp);
	}
	public void delete(int id) {
		employeeRepository.deleteById(id);
	}
	public void update(Employee emp) {
		employeeRepository.save(emp);
	}
}
