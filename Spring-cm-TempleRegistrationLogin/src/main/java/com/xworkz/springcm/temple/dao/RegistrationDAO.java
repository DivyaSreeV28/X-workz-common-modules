package com.xworkz.springcm.temple.dao;

import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

public interface RegistrationDAO {
	
	public void savePersonalInfoDetails(PersonalInfoENTITY personalInfoEntity,VisitingDetailsENTITY visitingDetailsEntity);
	
	public Long fetchCountByEmail(String emailId);
	
	public Long fetchCountByNumber(String number);
	
	public PersonalInfoENTITY fetchPersonalDetailsByEmailId(String emailId);
	
	public VisitingDetailsENTITY fetchVisitingDetailsByEmailId(String emailId);
	
}
