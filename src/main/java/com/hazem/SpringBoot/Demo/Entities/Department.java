package com.hazem.SpringBoot.Demo.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

@Entity 
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dep_id;
	
	@NotBlank(message = "Please Add a Department Name !")
	private String depName;
	private String dep_address;
	private String dep_code;

	public Department() {

	}

	public Department(long dep_id, String dep_name, String dep_address, String dep_code) {
		super();
		this.dep_id = dep_id;
		this.depName = dep_name;
		this.dep_address = dep_address;
		this.dep_code = dep_code;
	}

	public long getDep_id() {
		return dep_id;
	}

	public void setDep_id(long dep_id) {
		this.dep_id = dep_id;
	}

	public String getDepName() {
		return depName;
	}

	public void setDepName(String dep_name) {
		this.depName = dep_name;
	}

	public String getDep_address() {
		return dep_address;
	}

	public void setDep_address(String dep_address) {
		this.dep_address = dep_address;
	}

	public String getDep_code() {
		return dep_code;
	}

	public void setDep_code(String dep_code) {
		this.dep_code = dep_code;
	}

	@Override
	public String toString() {
		return "Department [dep_id=" + dep_id + ", dep_name=" + depName + ", dep_address=" + dep_address
				+ ", dep_code=" + dep_code + "]";
	}

}
