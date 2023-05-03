package com.example.New.Spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.New.Spring.dto.UserDto;
import com.example.New.Spring.entity.User;
import com.example.New.Spring.exeption.ResourceNotFound;
import com.example.New.Spring.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	public UserRepo userrepo;

	@Autowired
	public ModelMapper modelMapper;

	public UserDto userToUserDto(User user) {

		UserDto userdto = this.modelMapper.map(user, UserDto.class);

//		UserDto u = new UserDto();
//		u.setFirstName(user.getFirstName());
//		u.setLastName(user.getLastName());
//		u.setPassword(user.getPassword());
//		u.setCity(user.getCity());
//		u.setPhone(user.getPhone());

		return userdto;
	}

	public User userDtoToUser(UserDto userdto) {

		User user = this.modelMapper.map(userdto, User.class);

//		User u = new User();
//		u.setFirstName(userdto.getFirstName());
//		u.setLastName(userdto.getLastName());
//		u.setPassword(userdto.getPassword());
//		u.setCity(userdto.getCity());
//		u.setPhone(userdto.getPhone());
		return user;
	}

	@Override
	public String saveUser(UserDto userdto) {
		User user = userDtoToUser(userdto);
		user.getDepartment().setUser(user);
		userrepo.save(user);
		return "User Saved Successfully...";
	}

	@Override
	public List<UserDto> getAllUser() {
		return userrepo.findAll().stream().map(allUsers -> userToUserDto(allUsers)).collect(Collectors.toList());
	}

	@Override
	public UserDto getUser(int id) {
		return userToUserDto(userrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found...")));
	}

	@Override
	public String deleteUser(int id) {
		User u = userrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found..."));
		
		userrepo.delete(u);
		return "Delete successfully...";
	}

	@Override
	public String updateUser(UserDto userdto, int id) {
		User user = userrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found..."));

		userdto.setId(user.getId());
		userdto.getDepartment().setDepartmentId(user.getDepartment().getDepartmentId());
		userdto.getDepartment().setUser(userdto);

//		u.setFirstName(userdto.getFirstName());
//		u.setLastName(userdto.getLastName());
//		u.setPassword(userdto.getPassword());
//		u.setAddress(userdto.getAddress());
//		u.setPhone(userdto.getPhone());
		userrepo.save(userDtoToUser(userdto));
		return "User Updated Successfully....";
	}

	@Override
	public List<UserDto> findByFirstName(String firstName) {
		return userrepo.findByFirstName(firstName).stream().map(findByfname -> userToUserDto(findByfname))
				.collect(Collectors.toList());

	}

	@Override
	public List<UserDto> findByLastName(String lastName) {
		return userrepo.findByLastName(lastName).stream().map(findBylname -> userToUserDto(findBylname))
				.collect(Collectors.toList());

	}

	@Override
	public List<UserDto> findByFirstNameAndLastName(String firstName, String lastName) {
		return userrepo.findByFirstNameAndLastName(firstName, lastName).stream()
				.map(findByfnameAndlname -> userToUserDto(findByfnameAndlname)).collect(Collectors.toList());

	}

	@Override
	public List<UserDto> findByPhone(String phone) {
		return userrepo.findByPhone(phone).stream().map(findByPhone -> userToUserDto(findByPhone))
				.collect(Collectors.toList());

	}

	@Override
	public Map<String, String> findOnlyNameById(int id) {
		Map<String, String> map = new HashMap<String, String>();

		User user = userrepo.findById(id).orElseThrow(() -> new ResourceNotFound("User not found..."));
		map.put("firstName", user.getFirstName());
		map.put("lastName", user.getLastName());
		return map;
	}

	@Override
	public UserDto findByEmail(String email) {
		return userToUserDto(userrepo.getByEmail(email).orElseThrow(() -> new ResourceNotFound("User not found...")));
	}

	@Override
	public UserDto findByDepartmentid(int departmentId) {
		return userToUserDto(userrepo.findByDepartmentid(departmentId).orElseThrow(() -> new ResourceNotFound("User not found...")));
	}

}
