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
	public void savePersonalInfoDetails(PersonalInfoENTITY personalInfoEntity,VisitingDetailsENTITY visitingDetailsEntity) {
		Session session = factory.openSession();
		try {
			logger.info("Start: savePersonalInfoDetails method in RegistrationDAOImpl "+personalInfoEntity);
			logger.info("Factory " + factory);

			logger.info("Starting transaction");
			Transaction transaction = session.beginTransaction();
			logger.info("Persnal Entity is : " + personalInfoEntity);
			System.out.println("Visit Entity is :"+visitingDetailsEntity);
			session.save(personalInfoEntity);
			session.save(visitingDetailsEntity);
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
	public Long fetchCountByEmail(String emailId) {
		Session session = this.factory.openSession();
		try {
			logger.info("START : fetchCountByEmail ");

			// STEP 1: CREATE
			Query query = session.getNamedQuery("fetchCountByEmail");
			logger.info("QUERY---->" + query);
			query.setParameter("emailId", emailId);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to Long");
			Object result = query.uniqueResult();
			Long countByemailId = (Long) result;
			logger.info("returning count by emailId: "+countByemailId);
			return countByemailId;

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
			logger.info("Getting unique result and casting to Long");
			Object result = query.uniqueResult();
			Long countByNumber = (Long) result;
			return countByNumber;

		} catch (HibernateException he) {
			logger.error("Hibernate Exception in fetchCountByNumber " + he.getMessage() + he);
		} finally {
			logger.info("Session closed");
			session.close();
		}
		logger.info("END : fetchCountByNumber ");
		return null;
	}
	
	@Override
	public PersonalInfoENTITY fetchPersonalDetailsByEmailId(String emailId) {
		Session session = this.factory.openSession();
		try {
			System.out.println("START : fetchPersonalDetailsByEmailId " + emailId);

			// STEP 1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("fetchPersonalDetailsByEmailId");
			System.out.println("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to RegistrationDTO Object");
			Object result = query.uniqueResult();
			PersonalInfoENTITY entity = (PersonalInfoENTITY) result;
			return entity;

		} catch (HibernateException he) {
			System.err.println("=======> Hibernate Exception in fetchPersonalDetailsByEmailId " + he.getMessage() + he);
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("END : fetchPersonalDetailsByEmailId " + emailId);
		return null;
	}
	
	@Override
	public VisitingDetailsENTITY fetchVisitingDetailsByEmailId(String emailId) {
		Session session = this.factory.openSession();
		try {
			System.out.println("START : fetchByEmailId " + emailId);

			// STEP 1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("fetchVisitingDetailsByEmailId");
			System.out.println("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to RegistrationDTO Object");
			Object result = query.uniqueResult();
			VisitingDetailsENTITY entity = (VisitingDetailsENTITY) result;
			return entity;

		} catch (HibernateException he) {
			System.err.println("=======> Hibernate Exception in fetchVisitingDetailsByEmailId " + he.getMessage() + he);
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("END : fetchVisitingDetailsByEmailId " + emailId);
		return null;
	}
	
}
