package com.sainath.springbootdcb.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
private Long departmentId;
	@NotBlank(message = "Please add Department Name!!!")
private String departmentName;
private String departmentAddress;
private String departmentCode;
}
