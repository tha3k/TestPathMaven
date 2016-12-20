package th.co.geek.model;

import org.hibernate.validator.constraints.NotBlank;


public class Login {
	
	@NotBlank
	String userName;
	
 
	@NotBlank
	String password;


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}
	
	
	
	
	
	
}
