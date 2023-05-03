package com.example.New.Spring.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DepartmentDto {


	private int departmentId;
	
	@NotEmpty(message = "Please Enter Department name...")
	private String departmentName;
	
	@JsonIgnore
	private UserDto user;
	
}
