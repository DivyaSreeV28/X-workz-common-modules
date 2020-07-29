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

	private static final Logger logger=Logger.getLogger(RegistrationController.class);
	
	@Autowired
	public RegistrationSERVICE registrationService;

	
	public RegistrationController() {
		System.out.println("Created \t" + this.getClass().getSimpleName());
	}

	@RequestMapping(value="/register.cm", method=RequestMethod.POST)
	public String registerPage(RegistrationDTO registrationDto, Model model) {
		try {
			logger.info("Invoked register page with list values, success.jsp");
			logger.info(registrationDto);
			
			int isValid=registrationService.validateAndSaveDetails(registrationDto);
			if(isValid==0) {
				logger.info("Personal Information");
				model.addAttribute("name", "Full name is: "+registrationDto.getName());
				model.addAttribute("mobilenumber", "mobile number is: "+registrationDto.getMobileNumber());
				model.addAttribute("address", "address is: "+registrationDto.getAddress());
				model.addAttribute("age", "age is: "+registrationDto.getAge());
				model.addAttribute("emailid", "email id is: "+registrationDto.getEmailId());
				model.addAttribute("state", "state is: "+registrationDto.getState());
				logger.info("Visiting Details");
				model.addAttribute("date", "visiting date is: "+registrationDto.getDate());
				model.addAttribute("entrance", "special entrance type is: "+registrationDto.getSelist());
				model.addAttribute("pooja", "pooja type is: "+registrationDto.getPtlist());
				model.addAttribute("idcard", "government id type is: "+registrationDto.getIdcard());
				model.addAttribute("idnumber", "id card number is: "+registrationDto.getIdnumber());
				model.addAttribute("prasada", "prasada type is: "+registrationDto.getPrasada());
				model.addAttribute("noofpersons", "number of persons are: "+registrationDto.getNumberOfPersons());
				logger.info("Directing to success.jsp");
				return "Success";
			}else {
				System.out.println("Data not valid");
				model.addAttribute("Error", "Please check which field is not valid and enter valid data");
				return "Registration";
			}
		}catch (Exception e) {
			logger.error(e.getMessage(), e);
		}
		return null;
		
	}
	
}
