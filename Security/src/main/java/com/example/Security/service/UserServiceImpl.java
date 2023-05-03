package com.example.Security.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Security.entity.User;
import com.example.Security.repo.UserRepo;
import com.example.Security.security.ResourceNotFound;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userrepo;

	@Override
	public String saveUser(User user) {
		userrepo.save(user);
		return "Saved...";
	}

	@Override
	public List<User> getAll(User user) {
		return userrepo.findAll();
	}

	@Override
	public String deleteUser(int id) {
		 User u = userrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found..."));
		 userrepo.delete(u);
		 return "User deleted successfully...";
	}

	@Override
	public User getById(int id) {
		return userrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found..."));

	}

}
