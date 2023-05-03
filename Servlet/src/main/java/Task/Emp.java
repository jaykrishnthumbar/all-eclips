package Task;

public class Emp {

	private String user_name,password,email;
	
	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {                                                                                                                                                                                                                   
		this.user_name = user_name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
		
	}
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
		
	}

	@Override
	public String toString() {
		return "Emp [user_name=" + user_name + ", password=" + password + ", email=" + email + "]";
	}

}
