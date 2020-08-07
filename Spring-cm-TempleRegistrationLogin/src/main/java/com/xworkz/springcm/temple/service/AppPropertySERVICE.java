package com.xworkz.springcm.temple.service;

import java.util.List;

import com.xworkz.springcm.temple.dto.AppPropertyDTO;

public interface AppPropertySERVICE {

	public List<AppPropertyDTO> validateAndFetchAllByType(String type);
	
	
}
