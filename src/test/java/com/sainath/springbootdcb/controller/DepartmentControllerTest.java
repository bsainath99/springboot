package com.sainath.springbootdcb.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.forwardedUrlTemplate;
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
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.sainath.springbootdcb.entity.Department;
import com.sainath.springbootdcb.service.DepartmentService;

@WebMvcTest(DepartmentController.class)
public class DepartmentControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	private DepartmentService departmentService;
	private Department department;
	@BeforeEach
	void setUp() {
		 department=Department.builder()
				.departmentName("IT")
				.departmentAddress("Ahmedabad")
				.departmentCode("IT-06")
				.departmentId(1L)
				.build();
	}
	@Test
	void saveDepartment() throws Exception {
		Department inputDepartment=Department.builder()
				.departmentName("IT")
				.departmentAddress("Ahmedabad")
				.departmentCode("IT-06")
				.build();
		Mockito.when(departmentService.saveDepartment(inputDepartment)).thenReturn(department);

		mockMvc.perform(MockMvcRequestBuilders.post("/department/addDepartment").contentType(MediaType.APPLICATION_JSON).content("{\n" +
				"\t\"departmentName\":\"IT\",\n" +
				"\t\"departmentAddress\":\"Ahmedabad\",\n" +
				"\t\"departmentCode\":\"IT-06\"\n" +
				"}"	))
		.andExpect(MockMvcResultMatchers.status().isOk());

	}
	   @Test
	    void fetchDepartmentById() throws Exception {
	        Mockito.when(departmentService.findDepartmentById(1L))
	                .thenReturn(department);

	        mockMvc.perform(get("/department/get/1")
	        .contentType(MediaType.APPLICATION_JSON))
	        .andExpect(status().isOk())
	        .andExpect(jsonPath("$.departmentName").
	                value(department.getDepartmentName()));
	    }
}
