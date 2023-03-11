package com.startertech.springstarter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.startertech.springstarter.model.Empolyee;
import com.startertech.springstarter.service.EmpolyeeService;

@RestController
@RequestMapping("/api/employee")
public class Controller {

	@Autowired
	private EmpolyeeService empService;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public int addEmpolyee(@RequestBody Empolyee emp) {
		return empService.addEmployee(emp);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Empolyee> getAllEmpolyees(){
		return empService.getAllEmpolyees();
	}
	
	@GetMapping(path = "{id}")
	public Empolyee getEmployee(@PathVariable("id") int id) {
		return empService.getEmployee(id);
	}
	
	@DeleteMapping(path = "{id}")
	public int deleteEmployee(@PathVariable("id") int id) {
		return empService.deleteEmployee(id);
	}
	
	@PatchMapping(path= "{id}")
	public int updateEmployee(@PathVariable("id") int id, @RequestBody Empolyee empName) {
		return empService.updateEmployee(id, empName);
	}
}
