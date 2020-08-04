package com.xworkz.springcm.temple.service;

import com.xworkz.springcm.temple.dto.MailDTO;

public interface MailService {

	public boolean sendMail(MailDTO mailDto);
	
}
