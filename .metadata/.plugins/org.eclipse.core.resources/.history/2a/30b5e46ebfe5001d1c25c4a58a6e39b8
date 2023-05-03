package com.onerivet.deskbook.repo;

import java.awt.print.Pageable;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.onerivet.deskbook.entity.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer>{

//	@Query("SELECT u FROM user_table u WHERE u.email=:u.email")
	Optional<User> findByEmail(String email);

	

	

}
