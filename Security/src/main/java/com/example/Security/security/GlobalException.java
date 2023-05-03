package com.example.Security.security;

import java.time.LocalDateTime;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.Security.entity.Response1;

@RestControllerAdvice
public class GlobalException extends RuntimeException{
	
	@ExceptionHandler(ResourceNotFound.class)
	public Response1 resourceNotFoundHandler(ResourceNotFound exc) {
		
		String message = exc.getMessage();
		LocalDateTime now = LocalDateTime.now();
		Response1 res  =new Response1(message, now);
		return res;
		
	}

}
