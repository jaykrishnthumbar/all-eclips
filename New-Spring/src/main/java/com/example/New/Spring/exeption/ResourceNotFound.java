package com.example.New.Spring.exeption;

public class ResourceNotFound extends RuntimeException {

	private String message;

	public ResourceNotFound(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
