package com.hazem.SpringBoot.Demo.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hazem.SpringBoot.Demo.Entities.Department;
import com.hazem.SpringBoot.Demo.Errors.DepartmentNotFoundException;
import com.hazem.SpringBoot.Demo.repos.DepartmentRepository;

@Service
public class DepartmentServiceImpl implements DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Override
	public Department saveDepartment(Department department) {
		return departmentRepository.save(department);
	}

	@Override
	public List<Department> fetchDepartmentList() {
		return departmentRepository.findAll();
	}

	@Override
	public Department fetchDepartmentById(Long departmentId) throws DepartmentNotFoundException {
		Optional<Department> department = 
				departmentRepository.findById(departmentId);
		if (!department.isPresent()) {
			throw new DepartmentNotFoundException("Department Not Available!");
		}
		return department.get();
	}

	@Override
	public void deleteDepartmentById(Long departmentId) {
		departmentRepository.deleteById(departmentId);

	}

	@Override
	public Department updateDepartment(Long departmentId, Department department) {
		Department depDB = departmentRepository.findById(departmentId).get();

		if (Objects.nonNull(department.getDepName()) && !"".equalsIgnoreCase(department.getDepName())) {
			depDB.setDepName(department.getDepName());
		}

		if (Objects.nonNull(department.getDep_code()) && !"".equalsIgnoreCase(department.getDep_code())) {
			depDB.setDep_code(department.getDep_code());
		}

		if (Objects.nonNull(department.getDep_address()) && !"".equalsIgnoreCase(department.getDep_address())) {
			depDB.setDep_address(department.getDep_address());
		}

		return departmentRepository.save(depDB);
	}

	@Override
	public Department fetchDepartmentByName(String departmentName) {
		return departmentRepository.findBydepNameIgnoreCase(departmentName);

	}

}
