package com.xworkz.springcm.temple.service;

import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springcm.temple.dao.LoginDAO;
import com.xworkz.springcm.temple.dao.RegistrationDAO;
import com.xworkz.springcm.temple.dto.MailDTO;
import com.xworkz.springcm.temple.dto.RegistrationDTO;
import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

@Service
public class LoginSERVICEImpl implements LoginSERVICE {
	
	private static final Logger logger=Logger.getLogger(LoginSERVICEImpl.class);
	
	@Autowired
	public LoginDAO loginDao;
	
	@Autowired
	private MailService mailService;
	
	@Autowired
	private RegistrationDAO registrationDao;

	StringBuilder str = new StringBuilder("Hello!! \n");
	
	PersonalInfoENTITY personalEntity=new PersonalInfoENTITY();
	VisitingDetailsENTITY visitingEntity=new VisitingDetailsENTITY();
	RegistrationDTO registrationDto=new RegistrationDTO();

	public LoginSERVICEImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@Override
	public int validateAndUpdateDetails(String emailId,String password) {
		logger.info("Create: validateAndUpdateDetails " + emailId);
		try {
			if (Objects.nonNull(emailId) && emailId!=null && Objects.nonNull(password) && password!=null) {
				logger.info("Email and password are valid");
				
				logger.info("fetchPersonalDetailsByEmailIdAndPassword");
				personalEntity=loginDao.fetchPersonalDetailsByEmailIdAndPassword(emailId, password);
				logger.info("fetchVisitingDetailsByEmailId");
				visitingEntity=loginDao.fetchVisitingDetailsByEmailIdAndPassword(emailId, password);
				
				logger.info("getting email and password from database and comparing with sent email and password");
				String fetchedEmail=personalEntity.getEmailId();
				String fetchedPassword=personalEntity.getPassword();
				
				if (emailId.equalsIgnoreCase(fetchedEmail) && password.equalsIgnoreCase(fetchedPassword)) {
					logger.info("EmailId and Password matched successfully");
					
					logger.info("Sending Email for Login successfully");
					MailDTO mailDTO = new MailDTO("Divyasree", emailId, "Temple Registration ", str
							.append("Divya here, ").append("\n").append("Have a good day ahead...").append("\n\n")
							.append("Temple Registration logged in for registered email-Id given below").append("\n\n\n")
							.append("Email-Id is: ").append(emailId).append("\n").append("\n\n")
							.append(" Thank you for logging in").toString());

					mailService.sendMail(mailDTO);
					logger.info("Login Mail Sent Successfully");
				}
				return 1;
			} else {
				logger.error("Email or phone does not match");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception in validateAndUpdateDetails " + e.getMessage());
			e.printStackTrace();
		}
		logger.info("End: validateAndUpdateDetails " + emailId);
		return 0;
	}

	@Override
	public int validateEmailIdAndGeneratePassword(String emailId) {
		logger.info("Start: validateEmailIdAndGeneratePassword " + emailId);
		try {
			if(Objects.nonNull(emailId) && emailId!=null) {
				logger.info("Email is valid");
				Long emailCount=registrationDao.fetchCountByEmail(emailId);
				if(emailCount==1) {
					logger.info("Data is valid and can generate password");
					String generatedpassword=loginDao.generatePassword();
					System.out.println("*******************"+generatedpassword);
					logger.info("password generated of 8 digit alphanumeric");
					
					logger.info("Updating the generated password into database by calling validateAndUpdateDetails");
					
					logger.info("Updating PersonalInfo Details " + personalEntity);
					logger.info("Updating visitingInfo Details " + visitingEntity);
					int isUpdated=loginDao.updatePersonalInfoDetails(emailId,generatedpassword);
					if(isUpdated==1) {
						logger.info("Password updated for given email-id");
						
						logger.info("Sending Email and password for registered mail");
						MailDTO mailDTO = new MailDTO("Divyasree", emailId, "Temple Registration ", str
								.append("Divya here, ").append("\n").append("Have a good day ahead...").append("\n\n")
								.append("Temple Registration password is sent below,").append("\n\n\n")
								.append("Email-Id is: ").append(emailId).append("\n")
								.append("Password is: ").append(generatedpassword).append("\n\n")
								.append(" Thank you for registering").toString());

						mailService.sendMail(mailDTO);
						logger.info("Login Mail Sent Successfully");
						return 1;
					}else {
						logger.info("Password not updated for given email-id");
						return 0;
					}
				}else {
					logger.info("Email does not exists, re-check email-Id");
					return 0;
				}
			}else {
				logger.info("Email-Id provided in invalid");
				return 0;
			}
		} catch (Exception e) {
			logger.error("Exception in validateEmailIdAndGeneratePassword ", e);
		}
		logger.info("End: validateEmailIdAndGeneratePassword " + emailId);
		return 0;
	}
	
	
}
