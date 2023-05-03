package com.example.Security.service;

import java.util.List;

import com.example.Security.entity.User;

public interface UserService {
	
	public String saveUser(User user);

	public List<User> getAll(User user);

	public String deleteUser(int id);
	
	public User getById(int id);


}
