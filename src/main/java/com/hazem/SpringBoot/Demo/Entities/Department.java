package com.hazem.SpringBoot.Demo.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Department {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long dep_id;

	@NotBlank(message = "Please Add a Department Name !")
	private String depName;
	private String dep_address;
	private String dep_code;

}
