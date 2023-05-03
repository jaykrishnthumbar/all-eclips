package com.example.New.Spring.Controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.New.Spring.dto.UserDto;
import com.example.New.Spring.service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/welcome")

public class UserController {

	@Autowired
	private UserService userservice;

	@PostMapping("/saveuser")
	public String saveUser(@Valid @RequestBody UserDto userdto) {
		return userservice.saveUser(userdto);

	}

	@GetMapping("/getall")
	public List<UserDto> getAllUser(UserDto userdto) {
		return userservice.getAllUser();

	}
	
	@GetMapping("/getbyid/{id}")
	public UserDto getUser(@PathVariable int id) {
		return userservice.getUser(id);
		
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public String deleteUser(@PathVariable int id) {
		return userservice.deleteUser(id);
	}
	
	@PutMapping("/updatebyid/{id}")
	public String updateUser(@Valid @RequestBody UserDto userdto,@PathVariable int id) {
		return userservice.updateUser(userdto,id);
	}
	
	@GetMapping("/getbyfname")
	public List<UserDto> findByFirstName(@RequestBody String firstName) {
		return userservice.findByFirstName(firstName);
	}
	
	@GetMapping("/getbylname")
	public List<UserDto> findByLastName(@RequestBody String lastName) {
		return userservice.findByLastName(lastName);
	}
	
	@GetMapping("/getbyfnamelname")
	public List<UserDto> findByFirstNameAndLastName(@RequestBody String firstName,@RequestBody String lastName) {
		return userservice.findByFirstNameAndLastName(firstName, lastName);
	}
	
	@GetMapping("/getbyphone")
	public List<UserDto> findByPhone(@RequestBody String phone) {
		return userservice.findByPhone(phone);
	}
	
	@GetMapping("/onlynamebyid/{id}")
	public Map<String,String> findOnlyNameById(@PathVariable int id) {
		return userservice.findOnlyNameById(id);
		
	}
	
	@GetMapping("/getbyemail")
	public UserDto findByEmail(@RequestParam String email) {
		return userservice.findByEmail(email);
		
	}
	
	@GetMapping("/departmentid/{departmentId}")
	public UserDto findByDepartmentId(@PathVariable int departmentId) {
		return userservice.findByDepartmentid(departmentId);
		
	}
	
	

}
