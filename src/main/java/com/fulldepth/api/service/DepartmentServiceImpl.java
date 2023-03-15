package com.fulldepth.api.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.fulldepth.api.error.DepartmentNotFoundException;
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
	public Department getDeptById(long deptId) throws DepartmentNotFoundException {
 
		Optional<Department> depId= departmentRepository.findById(deptId);
		if(!depId.isPresent()) {
			throw new DepartmentNotFoundException("Department not exits for id: "+deptId);
		}
		return depId.get();
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

	public Department getDepartmentByName(String dName) {
		return departmentRepository.getByDepartmentNameIgnoreCase(dName);
	}

}
