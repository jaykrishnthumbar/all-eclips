package com.example.Springexample.userservice;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.Springexample.controller.User;
import com.example.Springexample.repo.UserRepo;

@Transactional
@Service
public class UserServiceimpl implements UserService {

	HashMap<Integer, User> map = new HashMap<Integer, User>();
	User u;
	

	@Autowired
	private UserRepo userRepo;

	@Override
	public String addUser(int id, User user) {
		map.put(id, user);
		userRepo.save(user);

		return "Added Successfullyy...";
	}

	@Override
	public List<User> allUser() {
		return userRepo.findAll();
	}

	@Override
	public User getUser(int id) {
		return userRepo.findById(id).get();
	}

	@Override
	public String deleteUser(int id) {
		u = userRepo.findById(id).get();
		if (u == null) {
			return "User Not Found...";
		}
		userRepo.delete(u);
		return "User Deleted Successfully...";
	}

	@Override
	public String updateUser(int id, User user) {
		u = userRepo.findById(id).get();
		if (u == null) {
			return "User Not Found...";
		}
		u.setName(user.getName());
		u.setEmail(user.getEmail());
		userRepo.save(u);
		return "User Updated Successfully....";
	}

	@Override
	public List<User> findUser(String name) {
		// TODO Auto-generated method stub
		return userRepo.findByName(name);
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return userRepo.getUserByEmail(email);
	}

}
