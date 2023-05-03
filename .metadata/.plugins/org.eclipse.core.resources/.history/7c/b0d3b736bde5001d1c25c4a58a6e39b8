package com.onerivet.deskbook.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.onerivet.deskbook.entity.User;

@Service
public interface UserService {
	
	public String saveUser(User user);
	
	public List<User> getAll(int pageNumber, int pageSize);
	
	public User getByid(int id);
	
	public String deleteUser(int id);
	
	public String updateUser(int id, User user);
	
	public User getByEmail(String email);

}
