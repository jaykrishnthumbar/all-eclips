package com.example.Security.password;

import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordEncode {
	@Bean
	public PasswordEncoder password() {
		return new BCryptPasswordEncoder(10);
	}

}
