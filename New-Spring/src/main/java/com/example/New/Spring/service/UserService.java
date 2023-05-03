package com.example.New.Spring.service;

import java.util.List;
import java.util.Map;

import com.example.New.Spring.dto.UserDto;

public interface UserService {

	public String saveUser(UserDto userdto);

	public List<UserDto> getAllUser();

	public UserDto getUser(int id);

	public String deleteUser(int id);

	public String updateUser(UserDto userdto, int id);

	public List<UserDto> findByFirstName(String firstName);

	public List<UserDto> findByLastName(String lastName);

	public List<UserDto> findByFirstNameAndLastName(String firstName, String lastName);

	public List<UserDto> findByPhone(String phone);

	public Map<String,String> findOnlyNameById(int id);

	public UserDto findByEmail(String email);

	public UserDto findByDepartmentid(int departmentId);

	//public List<UserDto> findByCity(String User);

}
