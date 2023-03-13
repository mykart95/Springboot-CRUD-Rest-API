package com.fulldepth.api.service;

import java.util.List;
import java.util.Objects;

import org.springframework.stereotype.Service;

import com.fulldepth.api.model.Department;
import com.fulldepth.api.repository.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService{

	private final DepartmentRepository departmentRepository;
	public DepartmentServiceImpl(DepartmentRepository departmentRepository) {
		this.departmentRepository=departmentRepository;
	}
	
	@Override
	public Department saveDepartment(Department dept) {
 		return departmentRepository.save(dept);
	}

	@Override
	public List<Department> getDepartments() {

		return departmentRepository.findAll();
	}

	@Override
	public Department getDeptById(long deptId) {
 
		return departmentRepository.findById(deptId).get();
	}

	@Override
	public void deleteDepartment(long id) {
 
		departmentRepository.deleteById(id);
	}

	@Override
	public Department updateDepartment(long deptId, Department dept) {
		
		Department deptDB= departmentRepository.findById(deptId).get();
		        //not null                            			//not blank
		if(Objects.nonNull(dept.getDepartmentName()) && !"".equalsIgnoreCase(dept.getDepartmentName())) {
			deptDB.setDepartmentName(dept.getDepartmentName());
		}
		
		if(Objects.nonNull(dept.getDepartmentAddress()) && !"".equalsIgnoreCase(dept.getDepartmentAddress())) {
			deptDB.setDepartmentAddress(dept.getDepartmentAddress());
		}
		
		if(Objects.nonNull(dept.getDepartmentCode()) && !"".equalsIgnoreCase(dept.getDepartmentCode())) {
			deptDB.setDepartmentCode(dept.getDepartmentCode());
		}
		
 		return departmentRepository.save(deptDB);
	}

}
