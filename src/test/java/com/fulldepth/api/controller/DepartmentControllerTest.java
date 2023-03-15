package com.fulldepth.api.controller;

//import static org.springframework.test.web.client.match.MockRestRequestMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.fulldepth.api.model.Department;
import com.fulldepth.api.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
class DepartmentControllerTest {

	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DepartmentService departmentService;
	private Department dept;
	
	@BeforeEach
	void setUp() throws Exception {
		dept=Department.builder()
				.departmentName("Trellix")
				.departmentAddress("Pine")
				.departmentCode("IT")
				.departmentId(1L)
				.build();
	}

	@Test
	void testSaveDepartment() throws Exception {
	Department deptInpt=Department.builder()
				.departmentName("Trellix")
				.departmentAddress("Pine")
				.departmentCode("IT")
				.departmentId(1L)
				.build();
		
		Mockito.when(departmentService.saveDepartment(deptInpt))
			.thenReturn(dept);
		
		mockMvc.perform(post("/department")
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\r\n"
						+ "	\"departmentName\":\"Trellix\",\r\n"
						+ "	\"departmentCode\":\"Pine\",\r\n"
						+ "	\"departmentAddress\":\"IT\"\r\n"
						+ "}"))
		.andExpect(status().isOk());
}

	@Test
	void testGetDeptById() throws Exception {
 
		Mockito.when(departmentService.getDeptById(1L))
		.thenReturn(dept);
		
		 mockMvc.perform(get("/department/1")
			        .contentType(MediaType.APPLICATION_JSON))
			        .andExpect(status().isOk())
			        .andExpect(jsonPath("$.departmentName")
			        		.value(dept.getDepartmentName()));
				
	}

}
