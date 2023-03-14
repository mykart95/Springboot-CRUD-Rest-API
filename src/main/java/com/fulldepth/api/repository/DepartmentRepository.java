package com.fulldepth.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fulldepth.api.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

	Department getByDepartmentName(String Dname);
	Department getByDepartmentNameIgnoreCase(String Dname);

	
}
