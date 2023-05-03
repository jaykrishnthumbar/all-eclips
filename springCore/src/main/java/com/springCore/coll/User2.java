package com.springCore.coll;

import java.util.List;
import java.util.Set;

public class User2 {
	private List<String> id;
	private String name;
	private String email;
	private Set<String> number;

	public List<String> getId() {
		return id;
	}

	public void setId(List<String> id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<String> getNumber() {
		return number;
	}

	public void setNumber(Set<String> number) {
		this.number = number;
	}

	public User2(List<String> id, String name, String email, Set<String> number) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.number = number;
	}

	public User2() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User2 [id=" + id + ", name=" + name + ", email=" + email + ", number=" + number + "]";
	}

}
