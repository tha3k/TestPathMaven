package th.co.geek;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import th.co.geek.action.exception.UserDuplicateException;
import th.co.geek.bean.UserProfile;
import th.co.geek.dao.UserProfileDAO;
import th.co.geek.model.Register;

@Controller
public class RegisterController {
	private static final Logger logger = LoggerFactory.getLogger(RegisterController.class);
	
	
	@RequestMapping(value="/register",   method = RequestMethod.POST)
	public ModelAndView onSubmit(@ModelAttribute("registerForm")@Valid Register register, BindingResult result) {
		System.out.println(register);
		
		if(!register.getConfirmPassword().equals(register.getPassword())){
			result.addError(new ObjectError("password", "Password do not match."));
		}
		
		if(register.getUserName().length() > 20){
			result.addError(new ObjectError("username", "Username length over limit 20."));
		}
		
		if(register.getPassword().length() < 6){
			result.addError(new ObjectError("password", "Password length must more 6 ."));
		}

		if(!validPassword(register.getPassword())){
			result.addError(new ObjectError("password", "At least 6 chars,Contains at least one digit,Contains at least one lower alpha char and one upper alpha char,Contains at least one char within a set of special char (@#%$^ etc.),Not containing blank, tab etc."));
		}

		
		
		try {
			UserProfile userProfile = new UserProfile();
			userProfile.setName(register.getUserName());
			userProfile.setEmail(register.getEmail());
			userProfile.setPassword(register.getPassword());
			UserProfileDAO userProfileDAO = UserProfileDAO.getInstance();
			userProfileDAO.addUserProfile(userProfile);
		} 
		catch (UserDuplicateException UdEx) {
			result.addError(new ObjectError("username", "Username already used!!"));
		}
		
		if (result.hasErrors()) {
			
			return new ModelAndView("registerForm");
		}

		
		logger.debug("registerSuccess ");
		return new ModelAndView("registerSuccess","register",register);
	}
	
	@RequestMapping(value = "/register",  method = RequestMethod.GET)
	public String register() {
		return "registerForm";
	}
	
	
	
	
	@ModelAttribute("registerForm")
	public Register registerForm() {
		Register regis = new Register();
		 
		return regis;
	}
	
	
	private static final String PASSWORD_PATTERN = "^.*(?=.{6,})(?=..*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$";
	public boolean validPassword(String password) {		
		try {
			 Pattern p = Pattern.compile(PASSWORD_PATTERN);
			 Matcher m = p.matcher(password);
			 return m.matches();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
 	
	
public static void main(String[] args) {
	RegisterController a = new  RegisterController();
	System.out.println(a.validPassword("4@A44a"));
}
	
	
}
