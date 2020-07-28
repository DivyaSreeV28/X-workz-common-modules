package com.xworkz.springcm.temple.dto;

import com.xworkz.springcm.temple.entity.AppPropertyENTITY;

public class RegistrationDTO {

	private int id;
	private String first_name;
	private String last_name;
	private String mobile_number;
	private String address;
	private String age;
	private String state;
	private String email;
	private String date;
	private String idnumber;
	private AppPropertyENTITY app_property_entity;
	
	public RegistrationDTO() {
		System.out.println("Created \t"+this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getMobile_number() {
		return mobile_number;
	}

	public void setMobile_number(String mobile_number) {
		this.mobile_number = mobile_number;
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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getIdnumber() {
		return idnumber;
	}

	public void setIdnumber(String idnumber) {
		this.idnumber = idnumber;
	}

	public AppPropertyENTITY getApp_property_entity() {
		return app_property_entity;
	}

	public void setApp_property_entity(AppPropertyENTITY app_property_entity) {
		this.app_property_entity = app_property_entity;
	}

	public RegistrationDTO(String first_name, String last_name, String mobile_number, String address, String age,
			String state, String email, String date, String idnumber, AppPropertyENTITY app_property_entity) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile_number = mobile_number;
		this.address = address;
		this.age = age;
		this.state = state;
		this.email = email;
		this.date = date;
		this.idnumber = idnumber;
		this.app_property_entity = app_property_entity;
	}

	@Override
	public String toString() {
		return "RegistrationDTO [id=" + id + ", first_name=" + first_name + ", last_name=" + last_name
				+ ", mobile_number=" + mobile_number + ", address=" + address + ", age=" + age + ", state=" + state
				+ ", email=" + email + ", date=" + date + ", idnumber=" + idnumber + ", app_property_entity="
				+ app_property_entity + "]";
	}
	
}
