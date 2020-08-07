package com.xworkz.springcm.temple.dto;

import org.apache.log4j.Logger;

public class MailDTO {

	private String from;
	private String to;
	private String subject;
	private String body;
	
	private static final Logger logger=Logger.getLogger(MailDTO.class);
	
	public MailDTO() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public String getFrom() {
		return from;
	}

//	@Value("${from}")
	public void setFrom(String from) {
		this.from = from;
	}

	public String getTo() {
		return to;
	}

	public void setTo(String to) {
		this.to = to;
	}

	public String getSubject() {
		return subject;
	}

//	@Value("${subject}")
	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getBody() {
		return body;
	}

//	@Value("${body}")
	public void setBody(String body) {
		this.body = body;
	}

	public MailDTO(String from, String to, String subject, String body) {
		super();
		this.from = from;
		this.to = to;
		this.subject = subject;
		this.body = body;
	}

	@Override
	public String toString() {
		return "MailDTO [from=" + from + ", to=" + to + ", subject=" + subject + ", body=" + body + "]";
	}

	
}
