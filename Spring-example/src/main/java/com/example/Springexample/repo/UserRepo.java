package com.example.Springexample.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.Springexample.controller.User;


@Repository
public interface UserRepo extends JpaRepository<User, Integer>{
	public List<User> findByName(String name);
	
	@Query("SELECT u FROM User u WHERE u.email=:email")
	public User getUserByEmail(@Param("email") String email);

}
