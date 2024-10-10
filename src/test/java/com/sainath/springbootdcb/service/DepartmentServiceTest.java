package com.sainath.springbootdcb.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.sainath.springbootdcb.entity.Department;
import com.sainath.springbootdcb.repository.DepartmentRepository;

@SpringBootTest
public class DepartmentServiceTest {
	@Autowired
	private DepartmentService departmentService;
	@MockBean
	private DepartmentRepository departmentRepository;
	@BeforeEach
	void setUp() {
		Department department=Department.builder()
				.departmentName("IT")
				.departmentAddress("Ahmedabad")
				.departmentCode("IT-06")
				.departmentId(1L)
				.build();
		Mockito.when(departmentRepository.findByDepartmentName("IT")).thenReturn(department);
	}
	@Test
	@DisplayName("Get Data based on Valid department Name")
	public void whenValidDepartmentName_thenDepartmentShouldFound(){
		String departmentName="IT";
		Department found=departmentService.findDepartmentByName(departmentName);
		assertEquals(departmentName,found.getDepartmentName());
	}
}
