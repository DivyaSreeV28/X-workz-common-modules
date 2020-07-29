package com.xworkz.springcm.temple.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "personal_info")
public class PersonalInfoENTITY {

	@Id
	@GenericGenerator(name = "xworkz", strategy = "increment")
	@GeneratedValue(generator = "xworkz")
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "mobile_number")
	private String mobileNumber;

	@Column(name = "address")
	private String address;

	@Column(name = "age")
	private String age;

	@Column(name = "email_id")
	private String emailId;

	@Column(name = "state")
	private String state;

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "visiting_details_id")
	private VisitingDetailsENTITY visitingDetailsEntity;

	private static final Logger logger = Logger.getLogger(PersonalInfoENTITY.class);

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

	public PersonalInfoENTITY() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public PersonalInfoENTITY(String name, String mobileNumber, String address, String age, String emailId,
			String state) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.emailId = emailId;
		this.state = state;
	}

	@Override
	public String toString() {
		return "PersonalInfoENTITY [id=" + id + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", age=" + age + ", emailId=" + emailId + ", state=" + state + "]";
	}

}
