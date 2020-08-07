package com.xworkz.springcm.temple.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.log4j.Logger;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name="app_property_table")
@NamedQueries({@NamedQuery(name="fetchAllByType",
		query="SELECT temple FROM AppPropertyENTITY temple WHERE temple.propType=:type")})
public class AppPropertyENTITY {

	@Id
	@GenericGenerator(name="xworkz",strategy = "increment")
	@GeneratedValue(generator = "xworkz")
	@Column(name="id")
	private int id;
	@Column(name="prop_name")
	private String propName;
	@Column(name="prop_value")
	private String propValue;
	@Column(name="prop_type")
	private String propType;
	
	private static final Logger logger=Logger.getLogger(AppPropertyENTITY.class);
	
	public AppPropertyENTITY() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPropName() {
		return propName;
	}

	public void setPropName(String propName) {
		this.propName = propName;
	}

	public String getPropValue() {
		return propValue;
	}

	public void setPropValue(String propValue) {
		this.propValue = propValue;
	}

	public String getPropType() {
		return propType;
	}

	public void setPropType(String propType) {
		this.propType = propType;
	}

	public AppPropertyENTITY(String propName, String propValue, String propType) {
		super();
		this.propName = propName;
		this.propValue = propValue;
		this.propType = propType;
	}

	@Override
	public String toString() {
		return "AppPropertyENTITY [id=" + id + ", propName=" + propName + ", propValue=" + propValue + ", propType="
				+ propType + "]";
	}

}
