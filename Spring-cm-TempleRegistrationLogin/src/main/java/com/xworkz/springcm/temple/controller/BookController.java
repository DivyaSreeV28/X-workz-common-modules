package com.xworkz.springcm.temple.controller;

import java.util.List;

import javax.annotation.PostConstruct;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.xworkz.springcm.temple.dto.AppPropertyDTO;
import com.xworkz.springcm.temple.dto.RegistrationDTO;
import com.xworkz.springcm.temple.service.AppPropertySERVICE;
import com.xworkz.springcm.temple.service.LoginSERVICE;

@Controller
@RequestMapping("/")
public class BookController {
	
	private static final Logger logger=Logger.getLogger(BookController.class);
	
	@Autowired
	private LoginSERVICE loginService;

	public BookController() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}
	
	@RequestMapping(value = "/book.cm", method = RequestMethod.POST)
	public String bookPage(RegistrationDTO registrationDto, Model model) {
		try {
			
			logger.info("Invoked Booking page with list values,later redirect to success.jsp");

			logger.info("Booking temple visting details");
			int isValid=loginService.validateAndSaveBookingDetails(registrationDto);
			if (isValid == 1) {
				
				model.addAttribute("success", "Booking done successfully..");

				logger.info("Directing to LoginSuccess.jsp");
				return "LoginSuccess";
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

	
}
