package com.xworkz.springcm.temple.dao;

import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

public interface LoginDAO {
	
	public int updatePersonalInfoDetails(String emailId,String password);
	
	public PersonalInfoENTITY fetchPersonalDetailsByEmailIdAndPassword(String emailId,String password);
	
	public VisitingDetailsENTITY fetchVisitingDetailsByEmailIdAndPassword(String emailId,String password);
	
	public String generatePassword();

}
