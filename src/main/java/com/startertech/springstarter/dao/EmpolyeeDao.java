package com.startertech.springstarter.dao;

import java.util.List;

import com.startertech.springstarter.model.Empolyee;

public interface EmpolyeeDao {

	int addEmployee(Empolyee emp);
	
	List<Empolyee> getAllEmpolyees();
	
	Empolyee getEmployee(int id);
	
	int deleteEmployee(int id);
	
	int updateEmployee(int id, Empolyee empName);
}
