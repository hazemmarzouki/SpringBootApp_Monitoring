package com.hazem.SpringBoot.Demo.Service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.hazem.SpringBoot.Demo.Entities.Department;
import com.hazem.SpringBoot.Demo.repos.DepartmentRepository;

@SpringBootTest
class DepartmentServiceTest {

	@Autowired
	private DepartmentService departmentService;

	@MockBean
	private DepartmentRepository departmentRepository;

	@BeforeEach
	void setUp() {
	Department department = Department.builder()
							.depName("IT")
							.dep_address("Tunis")
							.dep_code("IT-001")
							.dep_id(1L)
							.build();
	
	Mockito.when(departmentRepository.findBydepNameIgnoreCase("IT")).thenReturn(department);
	}

	@Test
	@DisplayName("Get Data Based on valid Department Name")
	public void whenValidDepName_DepFound_() {
		String departmentName = "IT";
		Department found = departmentService.fetchDepartmentByName(departmentName);

		assertEquals(departmentName, found.getDepName());
	}

}
