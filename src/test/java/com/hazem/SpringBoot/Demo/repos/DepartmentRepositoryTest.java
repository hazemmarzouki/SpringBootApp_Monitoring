package com.hazem.SpringBoot.Demo.repos;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.hazem.SpringBoot.Demo.Entities.Department;

@DataJpaTest
class DepartmentRepositoryTest {
	
	@Autowired
	private DepartmentRepository departmentRepository ;
	
	@Autowired
	private TestEntityManager testEntityManager;

	@BeforeEach
	void setUp() throws Exception {
		Department department = Department.builder()
				.depName("Finance")
				.dep_address("Ariana")
				.dep_code("FF-111")
				.build();
		testEntityManager.persist(department);
		
	}
	
	@Test
	public void whenFindById_returnDepartment() {
		Department department = departmentRepository.findById(1L).get();
		
		assertEquals(department.getDepName(),"Finance");
	}

	

}
