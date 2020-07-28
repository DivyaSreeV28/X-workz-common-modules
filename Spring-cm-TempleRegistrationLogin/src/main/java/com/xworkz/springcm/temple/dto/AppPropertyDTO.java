package com.xworkz.springcm.temple.dto;

import org.apache.log4j.Logger;

public class AppPropertyDTO {

	private int id;
	private String propName;
	private String propValue;
	private String propType;
	
	private static final Logger logger=Logger.getLogger(AppPropertyDTO.class);
	
	public AppPropertyDTO() {
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

	public static Logger getLogger() {
		return logger;
	}

	@Override
	public String toString() {
		return "AppPropertyDTO [id=" + id + ", propName=" + propName + ", propValue=" + propValue + ", propType="
				+ propType + "]";
	}

	
}
