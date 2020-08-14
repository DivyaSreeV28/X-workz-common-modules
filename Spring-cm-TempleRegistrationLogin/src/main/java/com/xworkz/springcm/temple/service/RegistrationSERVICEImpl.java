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

	StringBuilder str = new StringBuilder("Hello!! \n");

	private static final Logger logger = Logger.getLogger(RegistrationSERVICEImpl.class);

	public RegistrationSERVICEImpl() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	@Override
	public int validateAndSaveDetails(RegistrationDTO registrationDto) {
		logger.info("Create: validateAndSaveDetails " + registrationDto);
		int isValid = 1;
		try {
			if (Objects.nonNull(registrationDto)) {
				logger.info("Starting to validate fields..");

				String name = registrationDto.getName();
				if (name != null && !name.isEmpty()) {
					logger.info("Name is valid");
					isValid = 0;
				} else {
					logger.warn("Name is not valid");
					isValid = 1;
				}
				String address = registrationDto.getAddress();
				if (isValid == 0 && address != null && !address.isEmpty()) {
					logger.info("address is valid");
					isValid = 0;
				} else {
					logger.warn("address is not valid");
					isValid = 1;
				}
				String age = registrationDto.getAge();
				if (isValid == 0 && age != null && !age.isEmpty()) {
					logger.info("age is valid");
					isValid = 0;
				} else {
					logger.warn("age is not valid");
					isValid = 1;
				}
				String state = registrationDto.getState();
				if (isValid == 0 && state != null && !state.isEmpty()) {
					logger.info("State is valid");
					isValid = 0;
				} else {
					logger.warn("State is not valid");
					isValid = 1;
				}
				String emailId = registrationDto.getEmailId();
				if (isValid == 0 && emailId != null && !emailId.isEmpty()) {
					logger.info("Email Id is valid");
					isValid = 0;
				} else {
					logger.warn("Email Id is not valid");
					isValid = 1;
				}
				String mobileNumber = registrationDto.getMobileNumber();
				if (mobileNumber != null && !mobileNumber.isEmpty()) {
					logger.info("mobileNumber is valid");
					isValid = 0;
				} else {
					logger.warn("mobileNumber is not valid");
					isValid = 1;
				}
			}
			if (isValid == 0) {

				logger.info("If Count value returned is 0 then Email-id and number does not exist in database");
				Long emailCount = registrationDao.fetchCountByEmail(registrationDto.getEmailId());
				logger.info("Fetching count by Email-id returns: " + emailCount);
				Long numberCount = registrationDao.fetchCountByNumber(registrationDto.getMobileNumber());
				logger.info("Fetching count by Phone number returns: " + emailCount);
				if (emailCount == 0 && numberCount == 0) {

					logger.info("Data is valid and can save fields");
					PersonalInfoENTITY personalInfoEntity = new PersonalInfoENTITY();
					VisitingDetailsENTITY visitingDetailsEntity = new VisitingDetailsENTITY();

					logger.info("Copying data from personalInfoEntity to dto " + personalInfoEntity);
					BeanUtils.copyProperties(registrationDto, personalInfoEntity);
					logger.info("Copying data from visitingDetailsEntity to dto " + visitingDetailsEntity);
					BeanUtils.copyProperties(registrationDto, visitingDetailsEntity);
					
					logger.info("Mapping PersonalInfoENTITY with VisitingDetailsENTITY");
					personalInfoEntity.setVisitingDetailsEntity(visitingDetailsEntity);
					visitingDetailsEntity.setPersonalInfoEntity(personalInfoEntity);
					
					logger.info("Saving PersonalInfo Details " + personalInfoEntity);
					logger.info("Saving visitingInfo Details " + visitingDetailsEntity);
					registrationDao.savePersonalInfoDetails(personalInfoEntity,visitingDetailsEntity);

					logger.info("Sending Email");
					
					MailDTO mailDTO=initMail(registrationDto);

					mailService.sendMail(mailDTO);
					logger.info("Mail Sent Successfully");
					isValid = 0;
				}
				return isValid;
			} else {
				logger.error("Email or phone already exists");
				isValid = 1;
			}
			logger.info("End: validateAndSaveDetails " + registrationDto);
		} catch (Exception e) {
			logger.error("Exception in validateAndSaveDetails " + e.getMessage());
			e.printStackTrace();
		}
		return isValid;
	}

	@Override
	public RegistrationDTO validateAndResendMail(String emailId) {
		logger.info("Start: processing validateAndResendMail() "+emailId);
		PersonalInfoENTITY personalEntity=new PersonalInfoENTITY();
		VisitingDetailsENTITY visitingEntity=new VisitingDetailsENTITY();
		RegistrationDTO registrationDto=new RegistrationDTO();
		try {
			if(Objects.nonNull(emailId) && emailId!=null) {
				logger.info("Email is valid");
				personalEntity=registrationDao.fetchPersonalDetailsByEmailId(emailId);
				visitingEntity=registrationDao.fetchVisitingDetailsByEmailId(emailId);
				if (personalEntity != null && visitingEntity!=null ) {
					
					logger.info("==============>>personal entity is not null "+personalEntity);
					logger.info("==============>>visiting entity is not null "+visitingEntity);

					BeanUtils.copyProperties(personalEntity, registrationDto);
					BeanUtils.copyProperties(visitingEntity, registrationDto);
					logger.info("Copying personalEntity and visitingEntity details to registrationDto "+registrationDto);
					logger.info("Re-Sending Email to registered email-id "+emailId);
					
					MailDTO mailDTO=initMail(registrationDto);
					
					mailService.sendMail(mailDTO);
					logger.info("Mail Resent Successfully to "+emailId);
				}else {
					logger.error("RegistrationDto is null, so mail cant be sent");
				}
			}else {
				logger.info(emailId+" Email-Id provided doesnot exists try registering again or check email is correct or not");
			}
		}catch (Exception e) {
			logger.error("Exception invalidateAndResendMail ", e);
		}
		logger.info("End: processing validateAndResendMail() "+emailId);
		return registrationDto;
	}

	private MailDTO initMail(RegistrationDTO registrationDto) {
		String from="Divyasree";
		String subject="Temple Registration";
		String body=str.append("Divya here, ").append("\n").append("Have a good day ahead...").append("\n\n")
				.append("Temple Registration done successfully for below details, ").append("\n\n\n")
				.append("Personal Details: ").append("\n").append("Full Name is: ")
				.append(registrationDto.getName()).append("\n").append("Age is: ")
				.append(registrationDto.getAge()).append("\n").append("Address is: ")
				.append(registrationDto.getAddress()).append("\n").append("Email-Id is: ")
				.append(registrationDto.getEmailId()).append("\n").append("Mobile Number is: ")
				.append(registrationDto.getMobileNumber()).append("\n\n").append("Visiting Details: ")
				.append("Date of visiting: ").append(registrationDto.getDate()).append("\n")
				.append("Special list is: ").append(registrationDto.getSelist()).append("\n")
				.append("Prasada type is: ").append(registrationDto.getPrasada()).append("\n")
				.append("Government id card type is: ").append(registrationDto.getIdcard()).append("\n")
				.append("Id number is: ").append(registrationDto.getIdnumber()).append("\n")
				.append("Pooja type is: ").append(registrationDto.getPtlist()).append("\n")
				.append("Number of persons visiting are: ").append(registrationDto.getNumberOfPersons())
				.append("\n\n\n").append(" Thank you for registering.").toString();
		
		MailDTO mailDTO = new MailDTO(from, registrationDto.getEmailId(),subject , body);
		
	return mailDTO;
}
	
}
