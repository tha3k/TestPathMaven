package th.co.geek.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import redis.clients.jedis.Jedis;
import th.co.geek.action.exception.UserDuplicateException;
import th.co.geek.action.exception.UserNotfoundException;
import th.co.geek.bean.DatabaseKey;
import th.co.geek.bean.UserPost;
import th.co.geek.bean.UserProfile;

public class UserProfileDAO {
	private static UserProfileDAO _instance = new UserProfileDAO();
	
	private UserProfileDAO() {		
	}
	
	public static UserProfileDAO getInstance() {
		return _instance;
	}
	
	public UserProfile getUserProfile(String userName) throws Exception {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.USER_PREFIX+userName;
		
		if(jedis.exists(key)) {
			UserProfile userProfile = new UserProfile();
			userProfile.setName(jedis.hget(key, DatabaseKey.USER_NAME_KEY));
			userProfile.setPassword(jedis.hget(key, DatabaseKey.USER_PASSWORD_KEY));
			userProfile.setEmail(jedis.hget(key, DatabaseKey.USER_EMAIL_KEY));
			return userProfile;
		}
		else {	
			throw new UserNotfoundException();			
		}
    }		
		
		
	public void addUserProfile(UserProfile userProfile) throws UserDuplicateException {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);

		String key = DatabaseKey.USER_PREFIX+userProfile.getName();
		
		
	// check for dupplicate
		System.out.println(key);
		if(jedis.exists(key)) {
			throw new UserDuplicateException();
		}
		
		jedis.hset(key, DatabaseKey.USER_NAME_KEY, userProfile.getName());
		jedis.hset(key, DatabaseKey.USER_PASSWORD_KEY, userProfile.getPassword());
		jedis.hset(key, DatabaseKey.USER_EMAIL_KEY, userProfile.getEmail());
		
	}
	
	public ArrayList<String> getAllUserNameList() throws Exception {
		ArrayList<String> userNameList = new ArrayList<String>();
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		Set<String> allUserName = jedis.keys(DatabaseKey.USER_PREFIX+"*");
		
		Iterator<String> iteNameList = allUserName.iterator(); 
		while (iteNameList.hasNext()) {
			userNameList.add(iteNameList.next().replaceAll(DatabaseKey.USER_PREFIX, ""));
		}		
		return userNameList;
	}
	
	
	

	public UserProfile mockUserProfile() {
		UserProfile userProfile = new UserProfile();
		userProfile.setName("tha3k");
		userProfile.setPassword("111");
		userProfile.setEmail("tha3k@hotmail.com");
		
		ArrayList<UserPost> userPostList = new ArrayList<UserPost>();
		
		UserPost eachPost = new UserPost();
		eachPost.setPostUser("tha3k");
		eachPost.setPostDate("20130101");
		eachPost.setPostContent("test post for mock!!");
		eachPost.setCanDelete(false);
		
		userProfile.setPostList(userPostList);
		
		return userProfile;
	}	
	
	
	public static void main(String[] args) throws Exception {
		
		
		UserProfileDAO a = new UserProfileDAO();
		
		a.addUserProfile(a.mockUserProfile());
		System.out.println("all : "+a.getAllUserNameList());
		UserProfile b = a.getUserProfile("tha3k");
		System.out.println(b.getName());
		System.out.println(b.getPassword());
		System.out.println(b.getEmail());
	}

}
