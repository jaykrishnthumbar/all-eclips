package com.onerivet.deskbook.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.resource.OAuth2ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.oauth2.jwt.JwtDecoder;
import org.springframework.security.oauth2.jwt.NimbusJwtDecoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import com.onerivet.deskbook.password.PasswordEncode;



@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig {
	
	@Autowired
	public PasswordEncode passwordEncode;
	
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		
		http
		.csrf().disable()
		.cors()
		.and()
		.authorizeHttpRequests()
//		.requestMatchers("/save").hasRole("ADMIN")
//				(authorize) -> authorize.requestMatchers("/api/**").permitAll()
		.anyRequest().authenticated().and()
		.httpBasic();
		
		return http.build();
		
	}
	
//	@Bean
//	JwtDecoder jwtDecoder(OAuth2ResourceServerProperties properties) {
//
//		NimbusJwtDecoder jwtDecoder = NimbusJwtDecoder.withJwkSetUri(properties.getJwt().getJwkSetUri()).build();
//		OAuth2TokenValidator<Jwt> defaultValidator = new JwtTimestampValidator();
//		OAuth2TokenValidator<Jwt> audienceValidator = new CustomValidator(properties.getJwt().getAudiences());
//		jwtDecoder.setJwtValidator(new DelegatingOAuth2TokenValidator<>(defaultValidator, audienceValidator));
//		return jwtDecoder;
//	}
	
	@Bean
	UserDetailsService detailsService() {
		UserDetails user = User.builder()
				.username("Jacky")
				.password(this.passwordEncode.password().encode("Jacky@123"))
				.roles("USER")
				.build();
		UserDetails admin = User.builder()
				.username("Ronak")
				.password(this.passwordEncode.password().encode("Ronak@123"))
				.roles("ADMIN")
				.build();
		
		return new InMemoryUserDetailsManager(user, admin);
	}

}
