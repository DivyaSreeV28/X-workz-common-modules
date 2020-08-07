package com.xworkz.springcm.temple.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springcm.temple.dao.RegistrationDAO;
import com.xworkz.springcm.temple.dto.MailDTO;
import com.xworkz.springcm.temple.dto.RegistrationDTO;
import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

@Service
public class RegistrationSERVICEImpl implements RegistrationSERVICE {

	@Autowired
	private RegistrationDAO registrationDao;
	
	@Autowired
	private MailService mailService;
	
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
				String state=registrationDto.getState();
				if(isValid==0 && state!=null && !state.isEmpty() ) {
					logger.info("State is valid");
					isValid=0;
				}else {
					logger.warn("State is not valid");
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
				String mobileNumber=registrationDto.getMobileNumber();
				if(mobileNumber!=null && !mobileNumber.isEmpty() ) {
					logger.info("mobileNumber is valid");
					isValid=0;
				}else {
					logger.warn("mobileNumber is not valid");
					isValid=1;
				}
			}
			if(isValid==0) {
				
				Long emailCount=registrationDao.fetchCountByEmail(registrationDto.getEmailId());
				Long numberCount=registrationDao.fetchCountByNumber(registrationDto.getMobileNumber());
				if(emailCount==0 && numberCount==0) {
					
					logger.info("Data is valid and can save fields");
					PersonalInfoENTITY personalInfoEntity=new PersonalInfoENTITY();
					VisitingDetailsENTITY visitingDetailsEntity=new VisitingDetailsENTITY();
					
					logger.info("Mapping PersonalInfoENTITY with VisitingDetailsENTITY");
					personalInfoEntity.setVisitingDetailsEntity(visitingDetailsEntity);
					
					logger.info("Copying data from personalInfoEntity to dto");
					BeanUtils.copyProperties(registrationDto, personalInfoEntity);
					logger.info("Copying data from visitingDetailsEntity to dto");
					BeanUtils.copyProperties(registrationDto, visitingDetailsEntity);
					
					logger.info(personalInfoEntity);
					registrationDao.savePersonalInfoDetails(personalInfoEntity);
					logger.info(visitingDetailsEntity);
					registrationDao.saveVisitingDetails(visitingDetailsEntity);
					
					logger.info("Sending Email");
					MailDTO mailDTO=new MailDTO("Divyasree", registrationDto.getEmailId(), 
							"Temple Registration", "Hello, "+"\n"+"Divya here, "+"\n"+"Have a good day ahead..."+"\n\n"
									+ " Temple Registration done successfully for below details, "+"\n\n\n"
									+ "Personal Details: "+"\n"
									+ "Full Name is: "+registrationDto.getName() +"\n"
									+ "Age is: "+registrationDto.getAge() +"\n"
									+ "Address is: "+registrationDto.getAddress() +"\n"
									+ "Email-Id is: "+registrationDto.getEmailId() +"\n"
									+ "Mobile Number is: "+registrationDto.getMobileNumber() +"\n\n"
									+ "Visiting Details: "+"\n"
									+ "Date of visiting: "+registrationDto.getDate() +"\n"
									+ "Special list is: "+registrationDto.getSelist() +"\n"
									+ "Prasada type is: "+registrationDto.getPrasada() +"\n"
									+ "Government id card type is: "+registrationDto.getIdcard() +"\n"
									+ "Id number is: "+registrationDto.getIdnumber() +"\n"	
									+ "Pooja type is: "+registrationDto.getPtlist() +"\n"
									+ "Number of persons visiting are: "+registrationDto.getNumberOfPersons() +"\n\n\n"
									+" Thank you for registering.");
					mailService.sendMail(mailDTO);
				}
				return isValid;
			}else {
				logger.info("Email or phone already exists");
			}
			logger.info("End: validateAndSaveDetails "+registrationDto);
		} catch (Exception e) {
			logger.error("Exception in validateAndSaveDetails "+e.getMessage());
			e.printStackTrace();
		}
		return isValid;
	}
	
}
