package com.fulldepth.api.service;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.fulldepth.api.model.Department;
import com.fulldepth.api.repository.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;
	
	@BeforeEach
	void setUp() throws Exception {
		Department dept=Department.builder().departmentName("IT")
				.departmentAddress("Ahmedabad")
				.departmentCode("IT-06")
				.departmentId(1L)
				.build();
		
		Mockito.when(departmentRepository.getByDepartmentNameIgnoreCase("IT"))
				.thenReturn(dept);
	}

	@Test
	@DisplayName("ServiceTest")
	public void whenValidDeparmentName_DepartmentShouldFound() {
		String departmentName="IT";
		Department found= departmentService.getDepartmentByName(departmentName);
		assertEquals(departmentName, found.getDepartmentName());
	}

}
