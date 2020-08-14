package com.xworkz.springcm.temple.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "personal_info")
@NamedQueries({@NamedQuery(name="fetchCountByEmail",
		query="SELECT count(*) FROM PersonalInfoENTITY info where info.emailId=:emailId"),
	@NamedQuery(name="fetchCountByNumber",
		query="SELECT count(*) FROM PersonalInfoENTITY info where info.mobileNumber=:mobileNumber"),
	@NamedQuery(name="fetchPersonalDetailsByEmailId",
		query="SELECT p_info FROM PersonalInfoENTITY p_info where p_info.emailId=:emailId"),
	@NamedQuery(name="fetchVisitingDetailsByEmailId",
		query="SELECT v_info FROM VisitingDetailsENTITY v_info where p_id=(SELECT pId FROM PersonalInfoENTITY where emailId=:emailId)"),
	@NamedQuery(name="updatePersonalInfoDetails",
	query="UPDATE PersonalInfoENTITY SET password=:password where emailId=:emailId"),
	@NamedQuery(name="fetchPersonalDetailsByEmailIdAndPassword",
		query="SELECT p_info FROM PersonalInfoENTITY p_info where p_id=(SELECT pId FROM PersonalInfoENTITY where emailId=:emailId AND password=:password)"),
	@NamedQuery(name="fetchVisitingDetailsByEmailIdAndPassword",
		query="SELECT v_info FROM VisitingDetailsENTITY v_info where p_id=(SELECT pId FROM PersonalInfoENTITY where emailId=:emailId AND password=:password)"),
	@NamedQuery(name="fetchPasswordByEmailId",
		query="SELECT password FROM PersonalInfoENTITY p_info where p_info.emailId=:emailId")
})
public class PersonalInfoENTITY {

	@Id
	@GenericGenerator(name = "xworkz", strategy = "increment")
	@GeneratedValue(generator = "xworkz")
	@Column(name = "p_id")
	private int pId;

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
	
	@Column(name="password")
	private String password;

	@Column(name = "state")
	private String state;
	
	@Column(name="login_count")
	private int loginCount;

	//@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "personalInfoEntity")
	@OneToOne(cascade = CascadeType.ALL,mappedBy ="personalInfoEntity" )
	private VisitingDetailsENTITY visitingDetailsEntity;

	private static final Logger logger = Logger.getLogger(PersonalInfoENTITY.class);

	public int getId() {
		return pId;
	}

	public void setId(int id) {
		this.pId = id;
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

	
	public VisitingDetailsENTITY getVisitingDetailsEntity() {
		return visitingDetailsEntity;
	}

	public void setVisitingDetailsEntity(VisitingDetailsENTITY visitingDetailsEntity) {
		this.visitingDetailsEntity = visitingDetailsEntity;
	}

	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
	public int getLoginCount() {
		return loginCount;
	}

	public void setLoginCount(int loginCount) {
		this.loginCount = loginCount;
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

	public PersonalInfoENTITY(String name, String mobileNumber, String address, String age, String emailId,
			String password, String state, int loginCount, VisitingDetailsENTITY visitingDetailsEntity) {
		super();
		this.name = name;
		this.mobileNumber = mobileNumber;
		this.address = address;
		this.age = age;
		this.emailId = emailId;
		this.password = password;
		this.state = state;
		this.loginCount = loginCount;
		this.visitingDetailsEntity = visitingDetailsEntity;
	}

	@Override
	public String toString() {
		return "PersonalInfoENTITY [pId=" + pId + ", name=" + name + ", mobileNumber=" + mobileNumber + ", address="
				+ address + ", age=" + age + ", emailId=" + emailId + ", password=" + password + ", state=" + state
				+ ", loginCount=" + loginCount + ", visitingDetailsEntity=" + visitingDetailsEntity + "]";
	}

	
}
