package com.xworkz.springcm.temple.dao;

import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

public interface RegistrationDAO {
	
	public void savePersonalInfoDetails(PersonalInfoENTITY personalInfoEntity);
	
	public void saveVisitingDetails(VisitingDetailsENTITY visitingDetailsEntity);
	
	public Long fetchCountByEmail(String email);
	
	public Long fetchCountByNumber(String number);
	
}
