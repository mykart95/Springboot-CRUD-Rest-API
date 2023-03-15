package com.fulldepth.api.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fulldepth.api.error.DepartmentNotFoundException;
import com.fulldepth.api.model.Department;
import com.fulldepth.api.service.DepartmentService;

@RestController
public class DepartmentController {

	
	private final DepartmentService departmentService;
	
	private final Logger logger= LoggerFactory.getLogger(DepartmentController.class);
	
	public DepartmentController(DepartmentService departmentService) {
		this.departmentService=departmentService;
	}
	
	@PostMapping("/department")
	@ResponseStatus(HttpStatus.CREATED)
	public Department saveDepartment(@Valid @RequestBody Department dept) {
		logger.info("inside saveDepartment");
		return departmentService.saveDepartment(dept);
	}
	
	@GetMapping("/department")
	@ResponseStatus(HttpStatus.OK)
	public List<Department> getDepartments(){
		return departmentService.getDepartments();
	}
	
	@GetMapping("/department/{id}")
	public Department getDeptById(@PathVariable("id") long deptId) throws DepartmentNotFoundException {
		return departmentService.getDeptById(deptId);
	}
	
	@DeleteMapping("/department/{id}")
	@ResponseStatus(HttpStatus.OK)
	public String deleteDepartment(@PathVariable("id") long deptId) {
		departmentService.deleteDepartment(deptId);
		return "Department deleted sucessfully";
	}
	
	@PutMapping("/department/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Department updateDepartment(@PathVariable("id") long deptId, @RequestBody Department dept) {
		return departmentService.updateDepartment(deptId, dept);
	}
	
	@GetMapping("/department/name/{name}")
	public Department getDepartmentByName(@PathVariable("name") String dname) {
		return departmentService.getDepartmentByName(dname);
	}
	
}
