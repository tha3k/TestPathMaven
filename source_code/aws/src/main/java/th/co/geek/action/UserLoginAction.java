package th.co.geek.action;

import th.co.geek.action.exception.UserAuthenticationException;
import th.co.geek.bean.UserProfile;
import th.co.geek.dao.UserProfileDAO;

public class UserLoginAction {
	public UserProfile login(String userName, String password) throws Exception {
		return authenticate(userName, password);
	}
	public UserProfile authenticate(String userName, String password) throws Exception {
		UserProfile userProfile =  UserProfileDAO.getInstance().getUserProfile(userName);
		
		System.out.println(password+":"+userProfile.getPassword());
		if (password.equals(userProfile.getPassword()))
			System.out.println("log in success!!");
		else {
			System.out.println("log in failed!!");
			throw new UserAuthenticationException();
		}
		return userProfile;
	}
	
	public static void main(String[] args) throws Exception {
		UserLoginAction a = new UserLoginAction();
		a.authenticate("tha3k", "11111");
		
	}
	
}
