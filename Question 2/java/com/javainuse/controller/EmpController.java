//Write a program to describe Swagger API documentation.(hint: try to use GET,POST,PUT,DELTE)

package com.javainuse.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.model.Employee;
import com.javainuse.repository.EmpRepository;

@RestController
public class EmpController {

	@Autowired
	private EmpRepository repo;

	@RequestMapping(value = "/employees", method = RequestMethod.GET, produces = "application/json")
	public List<Employee> firstPage() {
		return repo.findAll();
	}

	@GetMapping("/employees/{id}")
	public Optional<Employee> getData(@PathVariable("id") int id) {
		return repo.findById(id);
	}

	@PostMapping
	public Employee insertData(@RequestBody Employee employee) {
		return repo.save(employee);
	}

	@DeleteMapping("/employees/{id}")
	public void deleteData(@PathVariable("id") int id) {
		repo.deleteById(id);
	}

	@PutMapping("/employee/{id}")
	public Employee updateData(@RequestBody Employee employee, @PathVariable("id") int id) {
		repo.save(employee);
		return employee;
	}
}
