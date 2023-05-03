package com.example.New.Spring.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
	
	private int id;
	
	@NotEmpty(message = "Please enter the First Name...")
	@Size(min = 3, max = 9,message = "Please enter the Data...")
	private String firstName;
	
	@NotEmpty(message = "Please enter the Last Name...")
	@Size(min = 3, max = 9, message = "Invalid..")
	private String lastName;
	
	@NotEmpty(message = "Please enter the email...")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
	private String email;
	
	
	@NotEmpty(message = "Please enter the Password...")
	@Size(min = 6, max = 15, message = "Invalid..")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$")
	private String password;
	
	@NotNull
	@Valid
	private AddressDto address;
	
	@NotEmpty(message = "Please enter the Phone Number...")
	@Size(min = 0, max = 10)
	@Pattern(regexp="(^$|[0-9]{10})")
	private String phone;
	
	@NotNull
	@Valid
	private DepartmentDto department;

	
	
	

	

}