package com.hazem.SpringBoot.Demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hazem.SpringBoot.Demo.Entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository< Department	, Long >{

	public Department findBydepName(String departmentName);
	public Department findBydepNameIgnoreCase( String departmentName);

	
	
}
