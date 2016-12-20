package th.co.geek.action;

import th.co.geek.dao.UserFollowDAO;

public class FollowAction {

	public void follow(String userName, String targetUserName) throws Exception {
		UserFollowDAO.getInstance().addFollower(targetUserName, userName);
		UserFollowDAO.getInstance().addFollowing(userName, targetUserName);
	}
	
	public void unFollow(String userName, String targetUserName) throws Exception {
		UserFollowDAO.getInstance().removeFollower(targetUserName, userName);
		UserFollowDAO.getInstance().removeFollowing(userName, targetUserName);
	}
	
	
	public static void main(String[] args) throws Exception {
		FollowAction a = new FollowAction();
		a.follow("tha3k", "boy01");
		System.out.println("tha3k[follower] : "+UserFollowDAO.getInstance().getFollowerList("tha3k"));
		System.out.println("tha3k[following] : "+UserFollowDAO.getInstance().getFollowingList("tha3k"));

		System.out.println("boy01[follower] : "+UserFollowDAO.getInstance().getFollowerList("boy01"));
		System.out.println("boy01[following] : "+UserFollowDAO.getInstance().getFollowingList("boy01"));

	}
	

}
