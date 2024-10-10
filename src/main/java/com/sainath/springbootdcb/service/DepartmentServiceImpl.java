package com.sainath.springbootdcb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sainath.springbootdcb.entity.Department;
import com.sainath.springbootdcb.error.DepartmentNotFoundException;
import com.sainath.springbootdcb.repository.DepartmentRepository;
@Service
public class DepartmentServiceImpl implements DepartmentService{
	@Autowired
private DepartmentRepository departmentRepository;
	@Override
	public Department saveDepartment(Department department) {
		
		return departmentRepository.save(department);
	}
	@Override
	public List<Department> getAllDepartments() {
		
		return departmentRepository.findAll();
	}
	@Override
	public Department findDepartmentById(Long id) throws DepartmentNotFoundException {
		
	Optional<Department> department= departmentRepository.findById(id);
	if(!department.isPresent()) {
		throw new DepartmentNotFoundException("Department Not Available");
	
	}
	return department.get();
	}
	@Override
	public void deleteDepartmentById(Long id) {
		 departmentRepository.deleteById(id);;
	}

	@Override
	public Department updateDepartmentById(Long id, Department department) {
		Department depDb=departmentRepository.findById(id).get();
		depDb.setDepartmentName(department.getDepartmentName());
		depDb.setDepartmentAddress(department.getDepartmentAddress());
		depDb.setDepartmentCode(department.getDepartmentCode());
		return  departmentRepository.save(depDb);
	}
	@Override
	public Department findDepartmentByName(String departmentName) {
		
		return departmentRepository.findByDepartmentName(departmentName);
	}

}
