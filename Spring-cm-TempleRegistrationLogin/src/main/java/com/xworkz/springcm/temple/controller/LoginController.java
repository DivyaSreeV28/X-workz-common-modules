package com.xworkz.springcm.temple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.springcm.temple.service.LoginSERVICE;

@Controller
@RequestMapping("/")
public class LoginController {

	private static final Logger logger = Logger.getLogger(LoginController.class);
	
	@Autowired
	public LoginSERVICE loginService;
	
	public LoginController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/login.cm", method = RequestMethod.POST)
	public String loginPage(String emailId,String password, Model model) {
		try {
			logger.info("Invoked login page with emailId and password,later redirect to loginsuccess.jsp");
			
			int isUpdated=loginService.validateAndUpdateDetails(emailId, password);
			if(isUpdated==1) {
				return "LoginSuccess";
			}else {
				return "Registration";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "Registration";
	}

	@RequestMapping(value = "/generatepassword.cm", method = RequestMethod.POST)
	public String generatingPasswordPage(String emailId, Model model) {
		try {
			logger.info("Invoked login page with emailId,later redirect to login.jsp");
			
			loginService.validateEmailIdAndGeneratePassword(emailId);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "Login";
	}

	@RequestMapping(value = "/forgotpassword.cm", method = RequestMethod.POST)
	public String forgotPasswordPage(String emailId, Model model) {
		try {
			logger.info("Invoked forgot password page with emailId,later redirect to login.jsp");
			
			loginService.validateEmailIdAndSendPassword(emailId);
			
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return "Login";
	}

	
}
