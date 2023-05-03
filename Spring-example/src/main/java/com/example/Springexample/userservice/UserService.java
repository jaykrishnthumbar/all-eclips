package com.example.Springexample.userservice;

import java.util.List;

import com.example.Springexample.controller.User;

public interface UserService {

	public String addUser(int id, User user);

	public List<User> allUser();

	public User getUser(int id);

	public String deleteUser(int id);

	public String updateUser(int id, User user);

	public List<User> findUser(String name);

	public User getUserByEmail(String email);

}
