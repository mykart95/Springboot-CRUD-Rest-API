package com.fulldepth.api.service;

import java.util.List;

import com.fulldepth.api.error.DepartmentNotFoundException;
import com.fulldepth.api.model.Department;

public interface DepartmentService {

	Department saveDepartment(Department dept);

	List<Department> getDepartments();

	Department getDeptById(long deptId) throws DepartmentNotFoundException;

	void deleteDepartment(long id);

	Department updateDepartment(long deptId, Department dept);

	Department getDepartmentByName(String dname);
	
}
