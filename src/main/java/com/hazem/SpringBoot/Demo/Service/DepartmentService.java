package com.hazem.SpringBoot.Demo.Service;

import java.util.List;

import com.hazem.SpringBoot.Demo.Entities.Department;
import com.hazem.SpringBoot.Demo.Errors.DepartmentNotFoundException;

public interface DepartmentService {

	public Department saveDepartment(Department department);

	public List<Department> fetchDepartmentList();

	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException;

	public void deleteDepartmentById(Long departmentId);

	public Department updateDepartment(Long departmentId, Department department);

	public Department fetchDepartmentByName(String departmentName);

}
