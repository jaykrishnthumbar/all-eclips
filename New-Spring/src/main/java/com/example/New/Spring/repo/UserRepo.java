package com.example.New.Spring.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.New.Spring.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

	public List<User> findByFirstName(String firstName);

	public List<User> findByLastName(String lastName);

	public List<User> findByFirstNameAndLastName(String firstName, String lastName);

	public List<User> findByPhone(String Phone);

	public Optional<User> getByEmail(String email);
	
	
	@Query("SELECT u FROM User u INNER JOIN u.department a WHERE a.departmentId=:departmentId")
	public Optional<User> findByDepartmentid(int departmentId);
	
	//public List<User> findByCity(String user);

}
