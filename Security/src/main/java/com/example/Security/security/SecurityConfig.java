package com.example.Security.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import com.example.Security.password.PasswordEncode;

@Configuration
@EnableWebSecurity
//@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	public PasswordEncode passwordEncode;

	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
//		.antMatchers().permitAll()
		.antMatchers("/").hasAnyRole("USER")
//		.antMatchers("/all-user").hasAnyRole("ADMIN")
		.anyRequest()
		.authenticated()
		.and()
		.httpBasic();
	}
	
	@Bean
	@Override
	protected UserDetailsService userDetailsService() {
		
		UserDetails user = User.builder()
				.username("Jacky")
				.password(this.passwordEncode.password().encode("Jacky@123"))
				.roles("USER")
//				.username("Ronak")
//				.password(this.passwordEncode.password().encode("Ronak@123"))
//				.roles("ADMIN")
				.build();
		UserDetails admin = User.builder()
				.username("Ronak")
				.password(this.passwordEncode.password().encode("Ronak@123"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
		
	}
	


}