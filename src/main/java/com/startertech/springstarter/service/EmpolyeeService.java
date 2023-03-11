package com.startertech.springstarter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.startertech.springstarter.dao.EmpolyeeDao;
import com.startertech.springstarter.model.Empolyee;

@Service
public class EmpolyeeService {

	@Autowired
	private EmpolyeeDao empolyeeDao;
	
	public int addEmployee(Empolyee emp) {
		return empolyeeDao.addEmployee(emp);
		
	}
	
	public List<Empolyee> getAllEmpolyees(){
		return empolyeeDao.getAllEmpolyees();
	}
	
	public Empolyee getEmployee(int id) {
		return empolyeeDao.getEmployee(id);
	}
	
	public int deleteEmployee(int id) {
		return empolyeeDao.deleteEmployee(id);
	}
	
	public int updateEmployee(int id, Empolyee empName) {
		return empolyeeDao.updateEmployee(id, empName);
	}
}
