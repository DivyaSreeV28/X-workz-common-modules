package com.xworkz.springcm.temple.service;

import com.xworkz.springcm.temple.dto.RegistrationDTO;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

public interface LoginSERVICE {
	
	public int validateAndUpdateDetails(String emailId,String password);
	
	public int validateEmailIdAndGeneratePassword(String emailId);
	
	public int validateEmailIdAndSendPassword(String emailId);
	
	public int validateAndSaveBookingDetails(RegistrationDTO registrationDto);

}
