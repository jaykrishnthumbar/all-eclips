package com.example.Springexample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Springexample.userservice.UserService;

@RestController
@RequestMapping("/welcome")
public class Controller {

	@Autowired
	private UserService userservice;

	@PostMapping("/adduser")
	public String addUser(@RequestBody User user) {
		return userservice.addUser(user.getId(), user);
	}

	@GetMapping("/alluser")
	public List<User> GetAll(User user) {
		return userservice.allUser();

	}

	@PostMapping("/getuser/{id}")
	public User getUserById(@PathVariable int id) {
		return userservice.getUser(id);

	}

	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		return userservice.deleteUser(id);

	}

	@PutMapping("/updateUser/{id}")
	public String update(@PathVariable int id, @RequestBody User user) {
		this.userservice.updateUser(id, user);
		return this.userservice.updateUser(id, user);

	}
	@GetMapping("/get-user-by-name")
	public List<User> name(String name) {
		return userservice.findUser(name);
		
	}
	@GetMapping("/get-user-by-email")
	public User email(String email) {
		return userservice.getUserByEmail(email);
	}

}
