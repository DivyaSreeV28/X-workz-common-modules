package com.xworkz.springcm.temple.service;

import com.xworkz.springcm.temple.dto.RegistrationDTO;

public interface RegistrationSERVICE {
	
	public int validateAndSaveDetails(RegistrationDTO registrationDto);
	
	public RegistrationDTO validateAndResendMail(String emailId);
	
}
