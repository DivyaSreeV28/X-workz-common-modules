package com.xworkz.springcm.temple.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.apache.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.xworkz.springcm.temple.dao.AppPropertyDAO;
import com.xworkz.springcm.temple.dto.AppPropertyDTO;
import com.xworkz.springcm.temple.entity.AppPropertyENTITY;

@Service
public class AppPropertySERVICEImpl implements AppPropertySERVICE {

	@Autowired
	private AppPropertyDAO dao;
	
	private static final Logger logger=Logger.getLogger(AppPropertySERVICEImpl.class);
	
	public AppPropertySERVICEImpl() {
		logger.info("Created \t"+this.getClass().getSimpleName());
	}

	public List<AppPropertyDTO> validateAndFetchAllByType(String type) {
		logger.info("Start: validateAndFetchAllByType ");
		try {
			
			List<AppPropertyENTITY> fetchedEntity = dao.fetchAllByType(type);
			logger.info("Copying data from dto to entity");
			if (Objects.nonNull(fetchedEntity)) {
				logger.info("List is found and its size is : " + fetchedEntity.size());
				List<AppPropertyDTO> list=new ArrayList<AppPropertyDTO>();
				
				for (AppPropertyENTITY fetchEntities : fetchedEntity) {

					AppPropertyDTO dto = new AppPropertyDTO();
					logger.info("created AppPropertyDTO object");
					BeanUtils.copyProperties(fetchEntities, dto);
					list.add(dto);
					logger.info("listDTO\t" + list);
				}
				
//				fetchedEntity.forEach(e->{
//					AppPropertyDTO dto=new AppPropertyDTO();
//					BeanUtils.copyProperties(dto, fetchedEntity);
//					logger.info("Dto list items: "+dto);
//					list.add(dto);
//				});
				return list;
			} else {
				logger.warn("List not found");
				return null;
			}
		} catch (Exception e) {
			logger.error("Exception in validateAndFetchAllByType " + e.getMessage());
			//e.printStackTrace();
		}
		logger.info("End: validateAndFetchAllByType ");
		return null;
	}

}
