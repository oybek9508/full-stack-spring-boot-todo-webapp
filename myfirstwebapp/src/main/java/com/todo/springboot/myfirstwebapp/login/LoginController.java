package com.todo.springboot.myfirstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class LoginController {
	private AuthenticationService authenticate;

	public LoginController(AuthenticationService authenticate) {
		super();
		this.authenticate = authenticate;
	}

	private Logger logger = LoggerFactory.getLogger(getClass());

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String goToLoginPage() {
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String goToWelcomePage(@RequestParam String name, @RequestParam String password, ModelMap model) {
		String errorMessage = "Name and password did not match";
		boolean isAuthenticated = authenticate.authenticate(name, password);
		logger.info("isAuthenticated {}", isAuthenticated);
		if (isAuthenticated) {
			model.put("name", name);
			model.put("password", password);
			return "welcome";
		}
		model.put("errorMessage", errorMessage);
		return "login";

	}

//	@RequestMapping("/welcome")
//	public String fetchWelcomePage(ModelMap model) {
//		return "welcome";
//	}

}
