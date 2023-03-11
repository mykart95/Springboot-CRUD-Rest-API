package com.startertech.springstarter.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.startertech.springstarter.model.Empolyee;

@Repository
public class EmpolyeeDaoImpl implements EmpolyeeDao {

	List<Empolyee> employee= new ArrayList<>();
	@Override
	public int addEmployee(Empolyee emp) {
 
		employee.add(emp);
		return 1;
	}
	@Override
	public List<Empolyee> getAllEmpolyees() {
 
		return employee;
	}
	@Override
	public Empolyee getEmployee(int id) {
 
		for(Empolyee emp: employee) {
			if(emp.getEmpId()==id) {
				return emp;
			}
		}
		return null;
	}
	@Override
	public int deleteEmployee(int id) {
 
		Empolyee empToDelete=null;
		for(Empolyee emp:employee) {
			if(emp.getEmpId()==id) 
				empToDelete=emp;
		}
			if(empToDelete!=null) {
				employee.remove(empToDelete);
				return 1;
			}
			else return 0;
		}
	@Override
	public int updateEmployee(int id, Empolyee empName) {
 
		Empolyee empToUpdate=null;
		for(Empolyee emp1:employee) {
			if(emp1.getEmpId()==id) {
				empToUpdate=emp1;
				break;
			}
		}
			if(empToUpdate!=null) {
				empToUpdate.setName(empName.getName());
				return 1;
			}else return 0;
	}

}
