package th.co.geek.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import redis.clients.jedis.Jedis;
import th.co.geek.bean.DatabaseKey;
import th.co.geek.bean.UserPost;
import th.co.geek.bean.UserProfile;

public class UserFollowDAO {
	private static UserFollowDAO _instance = new UserFollowDAO();
	
	private UserFollowDAO() {		
	}
	
	public static UserFollowDAO getInstance() {
		return _instance;
	}
	
	
// follow action 
	
	
	
	
	
	
// add + get follower
	public ArrayList<String> getFollowerList(String userName) throws Exception {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWER_PREFIX+userName;
		
		Set<String> tmpFollowerSet = jedis.smembers(key);
		return new ArrayList<String>(tmpFollowerSet);
	}		
		
	public void addFollower(String userName, String follower) {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWER_PREFIX+userName;
		
		System.out.println("pushing follower :: "+follower);
		jedis.sadd(key, follower);
	}

	public void removeFollower(String userName, String follower) {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWER_PREFIX+userName;
		
		System.out.println("remove follower :: "+follower);
		jedis.srem(key, follower);
	}


// add + get following
	public ArrayList<String> getFollowingList(String userName) throws Exception {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWING_PREFIX+userName;
		
		Set<String> tmpFollowingSet = jedis.smembers(key);
		return new ArrayList<String>(tmpFollowingSet);
	}		
		
	public void addFollowing(String userName, String following) {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWING_PREFIX+userName;
		
		System.out.println("pushing following :: "+following);
		jedis.sadd(key, following);
	}
	public void removeFollowing(String userName, String following) {
		Jedis jedis = new Jedis(DatabaseKey.REDIS_SERVER);
		String key = DatabaseKey.FOLLOWER_PREFIX+userName;
		
		System.out.println("remove following :: "+following);
		jedis.srem(key, following);
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
		
		
		UserFollowDAO a = new UserFollowDAO();
		
		a.addFollower("tha3k","ttttt3");
		a.removeFollower("tha3k","ttttt1");
		System.out.println("all : "+a.getFollowerList("tha3k"));
	}

}
