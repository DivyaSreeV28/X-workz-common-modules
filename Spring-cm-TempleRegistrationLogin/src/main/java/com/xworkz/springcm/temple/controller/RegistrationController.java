package com.xworkz.springcm.temple.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.springcm.temple.dto.RegistrationDTO;
import com.xworkz.springcm.temple.service.RegistrationSERVICE;

@Controller
@RequestMapping("/")
public class RegistrationController {

	private static final Logger logger = Logger.getLogger(RegistrationController.class);

	@Autowired
	public RegistrationSERVICE registrationService;

	public RegistrationController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value = "/register.cm", method = RequestMethod.POST)
	public String registerPage(RegistrationDTO registrationDto, Model model) {
		try {
			logger.info("Invoked register page with list values,later redirect to success.jsp");
			logger.info(registrationDto);

			int isValid = registrationService.validateAndSaveDetails(registrationDto);
			if (isValid == 0) {
				
				model.addAttribute("registrationDto", registrationDto);
				model.addAttribute("dataValid", true);

				logger.info("Directing to RegistrationSuccess.jsp");
				return "RegistrationSuccess";
			} else {
				System.out.println("Data not valid");
				model.addAttribute("Error", "Please check which field is not valid and enter valid data");
				return "Registration";
			}
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
	}

	@RequestMapping(value = "/resendmail.cm", method = RequestMethod.POST)
	public String resendMailPage(String emailId, Model model) {
		try {
			logger.info("Invoked resend mail page with registered email-id,later redirect to success.jsp");
			logger.info(emailId);

			RegistrationDTO registrationDto=registrationService.validateAndResendMail(emailId);
			
			model.addAttribute("registrationDto", registrationDto);
			model.addAttribute("dataValid", true);
			
			logger.info("Directing to RegistrationSuccess.jsp");
			return "RegistrationSuccess";
		} catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;

	}
}
