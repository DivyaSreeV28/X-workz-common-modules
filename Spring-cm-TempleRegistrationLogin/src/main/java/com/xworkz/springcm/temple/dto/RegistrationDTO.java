package com.xworkz.springcm.temple.dto;

import org.apache.log4j.Logger;

public class RegistrationDTO {

	private int id;
	private String name;
	private String mobileNumber;
	private String address;
	private String age;
	private String emailId;
	private String password;
	private String state;
	private int loginCount;
	
	private String date;
	private String numberOfPersons;
	private String selist;
	private String prasada;
	private String idcard;
	private String idnumber;
	private String ptlist;
	
	private static final Logger logger=Logger.getLogger(RegistrationDTO.class);
	
	public RegistrationDTO() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
	
	

	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(String numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	public String getSelist() {
		return selist;
	}

	public void setSelist(String selist) {
		this.selist = selist;
	}

	public String getPrasada() {
		return prasada;
	}

	public void setPrasada(String prasada) {
		this.prasada = prasada;
	}

	public String getIdcard() {
		return idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public String getPtlist() {
		return ptlist;
	}

	public void setPtlist(String ptlist) {
		this.ptlist = ptlist;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public RegistrationDTO(String name, String mobileNumber, String address, String age, String emailId, String state,
			String date, String numberOfPersons, String selist, String prasada, String idcard, String idnumber,
			String ptlist) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.emailId = emailId;
		this.state = state;
		this.date = date;
		this.numberOfPersons = numberOfPersons;
		this.selist = selist;
		this.prasada = prasada;
		this.idcard = idcard;
		this.idnumber = idnumber;
		this.ptlist = ptlist;
	}

	public RegistrationDTO(String name, String mobileNumber, String address, String age, String emailId,
			String password, String state, int loginCount, String date, String numberOfPersons, String selist,
			String prasada, String idcard, String idnumber, String ptlist) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.emailId = emailId;
		this.password = password;
		this.state = state;
		this.loginCount = loginCount;
		this.date = date;
		this.numberOfPersons = numberOfPersons;
		this.selist = selist;
		this.prasada = prasada;
		this.idcard = idcard;
		this.idnumber = idnumber;
		this.ptlist = ptlist;
	}

	@Override
	public String toString() {
		return "RegistrationDTO [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", age=" + age + ", emailId=" + emailId + ", password=" + password + ", state=" + state
				+ ", loginCount=" + loginCount + ", date=" + date + ", numberOfPersons=" + numberOfPersons + ", selist="
				+ selist + ", prasada=" + prasada + ", idcard=" + idcard + ", idnumber=" + idnumber + ", ptlist="
				+ ptlist + "]";
	}


}
