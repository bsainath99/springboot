package com.sainath.springbootdcb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sainath.springbootdcb.entity.Department;
import com.sainath.springbootdcb.error.DepartmentNotFoundException;
import com.sainath.springbootdcb.service.DepartmentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	@PostMapping("/addDepartment")
	public Department saveDepartment(@Valid @RequestBody Department department) {
		return departmentService.saveDepartment(department);

	}
	@GetMapping("/getAll")
	public List<Department> allDepartmemts(){
		return departmentService.getAllDepartments();
	}
	@GetMapping("/get/{id}")
	public Department getDepartmentById(@PathVariable Long id) throws DepartmentNotFoundException {
		return departmentService.findDepartmentById(id);
	}
	@GetMapping("/getByName/{id}")
	public Department getDepartmentByName(@PathVariable String departmentName) {
		return departmentService.findDepartmentByName(departmentName);
	}
	@DeleteMapping("/delete/{id}")
	public String deleteDepartment(@PathVariable Long id) {
		 departmentService.deleteDepartmentById(id);
		 return "Deleted DepartmentId with ID: "+id;
	}
	@PutMapping("/put/{id}")
	public Department updateDepartmentById(@PathVariable Long id,@RequestBody Department department) {
		return departmentService.updateDepartmentById(id,department);
	}
}
