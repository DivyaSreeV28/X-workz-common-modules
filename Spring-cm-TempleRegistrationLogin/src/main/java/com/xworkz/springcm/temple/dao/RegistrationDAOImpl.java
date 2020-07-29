package com.xworkz.springcm.temple.dao;

import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

@Repository
public class RegistrationDAOImpl implements RegistrationDAO {

	private SessionFactory factory;
	private static final Logger logger=Logger.getLogger(RegistrationDAOImpl.class);
	
	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}
	
	public RegistrationDAOImpl(SessionFactory factory) {
		logger.info("Created \t"+this.getClass().getSimpleName());
		this.factory = factory;
	}

	@Override
	public void savePersonalInfoDetails(PersonalInfoENTITY personalInfoEntity) {
		Session session = factory.openSession();
		try {
			logger.info("Start: savePersonalInfoDetails method in RegistrationDAOImpl "+personalInfoEntity);
			logger.info("Factory " + factory);

			logger.info("Starting transaction");
			Transaction transaction = session.beginTransaction();
			logger.info("Saving " + personalInfoEntity);
			session.save(personalInfoEntity);
			session.flush();
			transaction.commit();
			logger.info("Committed Transaction");
			
		} catch (Exception e) {
			logger.error("Exception in savePersonalInfoDetails method" + e.getMessage());
			session.getTransaction().rollback();
		}finally {
			logger.info("Closing session");
			session.close();
		}
		logger.info("End: savePersonalInfoDetails method in RegistrationDAOImpl "+personalInfoEntity);	
	}

	@Override
	public void saveVisitingDetails(VisitingDetailsENTITY visitingDetailsEntity) {
		Session session = factory.openSession();
		try {
			logger.info("Start: saveVisitingDetails method in RegistrationDAOImpl "+visitingDetailsEntity);
			logger.info("Factory " + factory);

			logger.info("Starting transaction");
			Transaction transaction = session.beginTransaction();
			logger.info("Saving " + visitingDetailsEntity);
			session.save(visitingDetailsEntity);
			session.flush();
			transaction.commit();
			logger.info("Committed Transaction");
			
		} catch (Exception e) {
			logger.error("Exception in saveVisitingDetails method" + e.getMessage());
			e.printStackTrace();
			session.getTransaction().rollback();
		}finally {
			logger.info("Closing session");
			session.close();
		}
		logger.info("End: saveVisitingDetails method in RegistrationDAOImpl "+visitingDetailsEntity);		
	}

	
}
