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
	public LoginSERVICE loginService;

	public BookController() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	private List<AppPropertyDTO> entryList;
	private List<AppPropertyDTO> prasadaList;
	private List<AppPropertyDTO> idList;
	private List<AppPropertyDTO> poojaTypeList;
	
	@Autowired
	public AppPropertySERVICE appPropertyService;
	
	@PostConstruct
	public void init() {
		logger.info("Invoked init method by post construct");
		logger.debug(appPropertyService);
		entryList=appPropertyService.validateAndFetchAllByType("se");
		logger.info("Special entry List: "+entryList);
		prasadaList=appPropertyService.validateAndFetchAllByType("prasada");
		logger.info("prasada List: "+prasadaList);
		idList=appPropertyService.validateAndFetchAllByType("id");	
		logger.info("id List: "+idList);
		poojaTypeList=appPropertyService.validateAndFetchAllByType("pt");
		logger.info("pooja Type List: "+poojaTypeList);
	}

//	@RequestMapping(value="/landing.cm", method=RequestMethod.GET)
//	public String landingPage(Model model) {
//		try {
//			logger.info("Invoked landing page with list values, register.jsp");
//			logger.debug(model);
//			model.addAttribute("specialEntryList", entryList);
//			model.addAttribute("prasadaList", prasadaList);
//			model.addAttribute("idList", idList);
//			model.addAttribute("poojaTypeList", poojaTypeList);
//			logger.info("Invoking list has completed try registering");
//			
//		}catch (Exception e) {
//			logger.error(e.getMessage(), e);
//		}
//		return "BookVisit";
//	}
	
	@RequestMapping(value = "/book.cm", method = RequestMethod.POST)
	public String bookPage(RegistrationDTO registrationDto, Model model) {
		try {
			logger.info("Invoked Booking page with list values,later redirect to success.jsp");

			logger.info("Booking temple visting details");
			int isValid=loginService.validateAndSaveBookingDetails(registrationDto);
			if (isValid == 0) {
				
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
