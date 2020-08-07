package com.xworkz.springcm.temple.dao;

import java.util.List;

import com.xworkz.springcm.temple.entity.AppPropertyENTITY;

public interface AppPropertyDAO {

	public List<AppPropertyENTITY> fetchAllByType(String type);
	
}
