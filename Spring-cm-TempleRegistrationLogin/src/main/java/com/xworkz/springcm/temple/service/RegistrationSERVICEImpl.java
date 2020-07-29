package com.xworkz.springcm.temple.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springcm.temple.dao.RegistrationDAO;
import com.xworkz.springcm.temple.dto.RegistrationDTO;
import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

@Service
public class RegistrationSERVICEImpl implements RegistrationSERVICE {

	@Autowired
	private RegistrationDAO registrationDao;
	
	private static final Logger logger=Logger.getLogger(RegistrationSERVICEImpl.class);
	
	public RegistrationSERVICEImpl() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}

	@Override
	public int validateAndSaveDetails(RegistrationDTO registrationDto) {
		logger.info("Create: validateAndSaveDetails "+registrationDto);
		int isValid=1;
		try {
			if(Objects.nonNull(registrationDto)) {
				logger.info("Starting to validate fields..");
			
				String name=registrationDto.getName();
				if(name!=null && !name.isEmpty() ) {
					logger.info("Name is valid");
					isValid=0;
				}else {
					logger.warn("Name is not valid");
					isValid=1;
				}
				String mobileNumber=registrationDto.getMobileNumber();
				if(mobileNumber!=null && !mobileNumber.isEmpty() ) {
					logger.info("mobileNumber is valid");
					isValid=0;
				}else {
					logger.warn("mobileNumber is not valid");
					isValid=1;
				}
				String address=registrationDto.getAddress();
				if(isValid==0 && address!=null && !address.isEmpty() ) {
					logger.info("address is valid");
					isValid=0;
				}else {
					logger.warn("address is not valid");
					isValid=1;
				}
				String age=registrationDto.getAge();
				if(isValid==0 && age!=null && !age.isEmpty() ) {
					logger.info("age is valid");
					isValid=0;
				}else {
					logger.warn("age is not valid");
					isValid=1;
				}
				String emailId=registrationDto.getEmailId();
				if(isValid==0 && emailId!=null && !emailId.isEmpty() ) {
					logger.info("Email Id is valid");
					isValid=0;
				}else {
					logger.warn("Email Id is not valid");
					isValid=1;
				}
				String state=registrationDto.getState();
				if(isValid==0 && state!=null && !state.isEmpty() ) {
					logger.info("State is valid");
					isValid=0;
				}else {
					logger.warn("State is not valid");
					isValid=1;
				}
			}
			if(isValid==0) {
				logger.info("Data is valid and can save fields");
				
				PersonalInfoENTITY personalInfoEntity=new PersonalInfoENTITY();
				VisitingDetailsENTITY visitingDetailsEntity=new VisitingDetailsENTITY();
				
				logger.info("Copying data from personalInfoEntity to dto");
				BeanUtils.copyProperties(registrationDto, personalInfoEntity);
				logger.info("Copying data from visitingDetailsEntity to dto");
				BeanUtils.copyProperties(registrationDto, visitingDetailsEntity);
				
				System.out.println(personalInfoEntity);
				registrationDao.savePersonalInfoDetails(personalInfoEntity);
				System.out.println(visitingDetailsEntity);
				registrationDao.saveVisitingDetails(visitingDetailsEntity);
				return isValid;
			}
			logger.info("End: validateAndSaveDetails "+registrationDto);
		} catch (Exception e) {
			logger.error("Exception in validateAndSaveDetails "+e.getMessage());
			e.printStackTrace();
		}
		return isValid;
	}
	
}
