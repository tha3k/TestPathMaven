package th.co.geek.model;

import java.util.ArrayList;

import org.hibernate.validator.constraints.NotBlank;

import th.co.geek.bean.UserPost;


public class Timeline {
	
	@NotBlank
	String userName;
	@NotBlank
	String message;
	
	ArrayList<UserPost> userPosts;
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public ArrayList<UserPost> getUserPosts() {
		return userPosts;
	}
	public void setUserPosts(ArrayList<UserPost> userPosts) {
		this.userPosts = userPosts;
	}
	
	

	
	
	
	
	
	
	
}
