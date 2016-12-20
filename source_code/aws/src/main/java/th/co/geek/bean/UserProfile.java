package th.co.geek.bean;

import java.util.ArrayList;

public class UserProfile {
	private String name;
	private String email;
	private String password;
	
	private ArrayList<String> followingList = new ArrayList<String>();
	private ArrayList<String> followerList = new ArrayList<String>();
	
	private ArrayList<UserPost> postList = new ArrayList<UserPost>();

	
	
	public UserProfile() {	
	}
	
	public UserProfile(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<String> getFollowingList() {
		return followingList;
	}

	public void setFollowingList(ArrayList<String> followingList) {
		this.followingList = followingList;
	}

	public ArrayList<String> getFollowerList() {
		return followerList;
	}

	public void setFollowerList(ArrayList<String> followerList) {
		this.followerList = followerList;
	}

	public ArrayList<UserPost> getPostList() {
		return postList;
	}

	public void setPostList(ArrayList<UserPost> postList) {
		this.postList = postList;
	}
	
	public String toString() {
		String following = "following[";
		for (int i=0;i<followerList.size();i++) {
			following += followingList.get(i);
		}
		following+="]";
			
		String follower = "follower[";
		for (int i=0;i<followerList.size();i++) {
			follower += followerList.get(i);
		}
		follower+="]";
		
		return following+":"+follower;
	}
	
}
