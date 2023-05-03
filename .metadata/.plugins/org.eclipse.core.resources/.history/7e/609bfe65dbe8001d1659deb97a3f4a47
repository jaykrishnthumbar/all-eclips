package com.onerivet.deskbook.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.onerivet.deskbook.entity.AuthRequest;
import com.onerivet.deskbook.entity.User;
import com.onerivet.deskbook.service.UserService;
import com.onerivet.deskbook.util.jwtUtil;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	private UserService userservice;

	@Autowired
	private jwtUtil jwtUtil;

	@Autowired
	private AuthenticationManager authenticationManager;

//	@PreAuthorize("hashrole('ADMIN')")
	@GetMapping("/deskbook")
	public String test() {
		return "You are in deskbook application...";

	}

//	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/save")
	public String save(@Valid @RequestBody User user) {
		return userservice.saveUser(user);

	}

//	@PreAuthorize("hasRole('ADMIN')")
	@GetMapping("/all")
	public List<User> getAll(@RequestParam(value = "pageNumber", defaultValue = "0", required = false) int pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "3", required = false) int pageSize) {
		return userservice.getAll(pageNumber, pageSize);
	}

	@GetMapping("/user-by-id/{id}")
	public User findById(@PathVariable int id) {
		return userservice.getByid(id);

	}

//	@PreAuthorize("hasRole('ADMIN')")
	@DeleteMapping("/delete/{id}")
	public String deleteUser(@PathVariable int id) {
		return userservice.deleteUser(id);

	}

	@PutMapping("/update/{id}")
	public String updateUser(@PathVariable int id, @Valid @RequestBody User user) {
		return userservice.saveUser(user);

	}

	@GetMapping("/user-by-email")
	public User findByEmail(@RequestParam String email) {
		return userservice.getByEmail(email);

	}

	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthRequest authRequest) throws Exception {

		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword()));
		} catch (Exception e) {
			throw new Exception("invalid email/password...");
		}
		return jwtUtil.generateToken(authRequest.getEmail());

	}

}
