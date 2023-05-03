package com.onerivet.deskbook.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user_table")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@NotEmpty(message = "Enter the first name...")
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,30}", message = "Enter valid first name...")
	private String firstName;

	@NotEmpty(message = "Enter the last name...")
	@Pattern(regexp = "[A-Z]{1}[a-z]{3,30}", message = "Enter valid last name...")
	private String lastName;

	@NotEmpty(message = "Enter the email...")
	@Pattern(regexp = "^[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+(?:\\\\.[a-zA-Z0-9_!#$%&'*+/=?`{|}~^-]+)*@[a-zA-Z0-9-]+(?:\\\\.[a-zA-Z0-9-]+)*$", message = "Enter email in valid format...(EX:Abc@123)")
	private String email;

	@NotEmpty(message = "Enter the password...")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&-+=()])(?=\\S+$).{8,20}$", message = "enter password in valid formate...(EX:Abc@gmail.com)")
	private String password;

	@NotEmpty(message = "Enter the mobile number...")
	@Pattern(regexp = "[0-9]{10}", message = "Enter valid mobile number...")
	private String mobile;

	@NotEmpty(message = "Enter the city...")
	@Pattern(regexp = "[A-Z]{1}[a-z]*", message = "First letter must be in uppercase...")
	private String city;

}
