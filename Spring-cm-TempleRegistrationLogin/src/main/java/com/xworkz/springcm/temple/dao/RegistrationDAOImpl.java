package com.xworkz.springcm.temple.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
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
			e.printStackTrace();
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

	@Override
	public Long fetchCountByEmail(String email) {
		Session session = this.factory.openSession();
		try {
			logger.info("START : fetchCountByEmail ");

			// STEP 1: CREATE
			Query query = session.getNamedQuery("fetchCountByEmail");
			logger.info("QUERY---->" + query);
			query.setParameter("emailId", email);
			// STEP 2: PROCESS
			Object result = query.uniqueResult();
			Long countByPrice = (Long) result;
			return countByPrice;

		} catch (HibernateException he) {
			logger.error("Hibernate Exception in fetchCountByEmail " + he.getMessage() + he);
		} finally {
			logger.info("Session closed");
			session.close();
		}
		logger.info("END : fetchCountByEmail ");
		return null;
	}

	@Override
	public Long fetchCountByNumber(String number) {
		Session session = this.factory.openSession();
		try {
			logger.info("START : fetchCountByNumber ");

			// STEP 1: CREATE
			Query query = session.getNamedQuery("fetchCountByNumber");
			logger.info("QUERY---->" + query);
			query.setParameter("mobileNumber", number);
			// STEP 2: PROCESS
			Object result = query.uniqueResult();
			Long countByPrice = (Long) result;
			return countByPrice;

		} catch (HibernateException he) {
			logger.error("Hibernate Exception in fetchCountByNumber " + he.getMessage() + he);
		} finally {
			logger.info("Session closed");
			session.close();
		}
		logger.info("END : fetchCountByNumber ");
		return null;
	}
}
