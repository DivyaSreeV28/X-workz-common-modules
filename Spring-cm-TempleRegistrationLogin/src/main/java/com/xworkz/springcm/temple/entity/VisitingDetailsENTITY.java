package com.xworkz.springcm.temple.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="visiting_details")
public class VisitingDetailsENTITY {

	@Id
	@GenericGenerator(name="xworkz",strategy = "increment")
	@GeneratedValue(generator = "xworkz")
	@Column(name="v_id")
	private int id;
	
	@Column(name="date")
	private String date;
	
	@Column(name="selist")
	private String selist;
	
	@Column(name="prasada")
	private String prasada;
	
	@Column(name="id_card")
	private String idcard;
	
	@Column(name="idnumber")
	private String idnumber;
	
	@Column(name="ptlist")
	private String ptlist;
	
	@Column(name="no_of_persons")
	private String numberOfPersons;
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "visitingDetailsEntity")
	private PersonalInfoENTITY personalInfoEntity;
	
	private static final Logger logger=Logger.getLogger(VisitingDetailsENTITY.class);
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
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

	public String getNumberOfPersons() {
		return numberOfPersons;
	}

	public void setNumberOfPersons(String numberOfPersons) {
		this.numberOfPersons = numberOfPersons;
	}

	
	public PersonalInfoENTITY getPersonalInfoEntity() {
		return personalInfoEntity;
	}

	public void setPersonalInfoEntity(PersonalInfoENTITY personalInfoEntity) {
		this.personalInfoEntity = personalInfoEntity;
	}

	public VisitingDetailsENTITY() {
		logger.info("Created \t" + this.getClass().getSimpleName());
	}

	public VisitingDetailsENTITY(String date, String selist, String prasada, String idcard, String idnumber,
			String ptlist, String numberOfPersons) {
		super();
		this.date = date;
		this.selist = selist;
		this.prasada = prasada;
		this.idcard = idcard;
		this.idnumber = idnumber;
		this.ptlist = ptlist;
		this.numberOfPersons = numberOfPersons;
	}

	@Override
	public String toString() {
		return "VisitingDetailsENTITY [id=" + id + ", date=" + date + ", selist=" + selist + ", prasada=" + prasada
				+ ", idcard=" + idcard + ", idnumber=" + idnumber + ", ptlist=" + ptlist + ", numberOfPersons="
				+ numberOfPersons + "]";
	}

	
}
