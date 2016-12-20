package th.co.geek;

import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import th.co.geek.dao.UserProfileDAO;

@Controller
public class AllUserController {
	@RequestMapping(value="/allUser", method = RequestMethod.GET)
	public String getAllList(Locale locale, Model model) {
		try {
			model.addAttribute("allUserList", UserProfileDAO.getInstance().getAllUserNameList());
		} 
		catch (Exception ex) {
			ex.printStackTrace();
		}
		return "allUser";
	}
	
	//@RequestMapping(value = "/login",  method = RequestMethod.GET)
	public String login() {
		return "loginForm";
	}

}
