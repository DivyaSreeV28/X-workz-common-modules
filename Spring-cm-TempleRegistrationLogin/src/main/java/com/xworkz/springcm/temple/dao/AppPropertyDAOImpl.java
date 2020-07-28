package com.xworkz.springcm.temple.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.xworkz.springcm.temple.entity.AppPropertyENTITY;

@Repository
public class AppPropertyDAOImpl implements AppPropertyDAO {

	private SessionFactory factory;
	private static final Logger logger=Logger.getLogger(AppPropertyDAOImpl.class);
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public AppPropertyDAOImpl(SessionFactory factory) {
		logger.info("Created \t"+this.getClass().getSimpleName());
		this.factory = factory;
	}

	public List<AppPropertyENTITY> fetchAllByType(String type) {
		Session session = this.factory.openSession();
		try {
			logger.info("START : fetchAllByType " + type);
			// STEP1: CREATE
			Query query = session.getNamedQuery("fetchAllByType");
			logger.info("QUERY---->" + query);
			query.setParameter("type", type);
			// STEP2: PROCESS
			List<AppPropertyENTITY> fetchedList = query.getResultList();
			return fetchedList;
		} catch (HibernateException he) {
			logger.error("Hibernate Exception in fetchAllByType " + he.getMessage());
		} finally {
			session.close();
		}
		logger.info("END : fetchAllByType " + type);
		return null;
	}

	
}
