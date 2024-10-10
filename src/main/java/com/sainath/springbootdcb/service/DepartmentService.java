package com.sainath.springbootdcb.service;

import java.util.List;

import com.sainath.springbootdcb.entity.Department;
import com.sainath.springbootdcb.error.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> getAllDepartments();

	public Department findDepartmentById(Long id) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long id);
public Department findDepartmentByName(String departmentName);

	public Department updateDepartmentById(Long id, Department department);

}
