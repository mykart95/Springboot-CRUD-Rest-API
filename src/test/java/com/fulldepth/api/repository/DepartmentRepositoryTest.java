package com.fulldepth.api.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.fulldepth.api.model.Department;

@DataJpaTest
class DepartmentRepositoryTest {

	@Autowired
	private DepartmentRepository departmentRepository;
	@Autowired
	private TestEntityManager entityManager;
	
	@BeforeEach
	void setUp() throws Exception {
		Department dept=Department.builder()
				.departmentName("Mech")
				.departmentCode("ME-06")
				.departmentAddress("Delhi")
				.build();
		entityManager.persist(dept);
	}

	@Test
	public void WhenFindById_thenRetrunDepartment() {
		Department dept=departmentRepository.findById(1L).get();
		assertEquals(dept.getDepartmentName(), "Mech");
	}

}
