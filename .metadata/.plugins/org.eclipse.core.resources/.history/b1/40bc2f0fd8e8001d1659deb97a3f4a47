package com.onerivet.deskbook.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.onerivet.deskbook.entity.User;
import com.onerivet.deskbook.exception.ResourceNotFound;
import com.onerivet.deskbook.repo.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserRepo userRepo;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		User user = this.userRepo.findByEmail(email).orElseThrow(() -> new ResourceNotFound("email not found..."));
		return new UserDetailsImpl(user);
	}

}
