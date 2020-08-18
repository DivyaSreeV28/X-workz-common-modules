package com.xworkz.springcm.temple.dao;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.springcm.temple.entity.PersonalInfoENTITY;
import com.xworkz.springcm.temple.entity.VisitingDetailsENTITY;

@Repository
public class LoginDAOImpl implements LoginDAO {

	private static final Logger logger = Logger.getLogger(LoginDAOImpl.class);

	private SessionFactory factory;

	@Autowired
	public void setFactory(SessionFactory factory) {
		this.factory = factory;
	}

	public LoginDAOImpl(SessionFactory factory) {
		logger.info("Created \t" + this.getClass().getSimpleName());
		this.factory = factory;
	}

	@Override
	public int updatePersonalInfoDetails(String emailId, String password) {
		logger.info("Start: updatePersonalInfoDetails " + emailId);
		Session session = factory.openSession();
		try {
			logger.info("Start: updatePersonalInfoDetails method in LoginDAOImpl " + emailId);
			logger.info("Factory " + factory);

			session.beginTransaction();
			// STEP1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("updatePersonalInfoDetails");
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			// STEP 2: PROCESS
			int rowsUpdated = query.executeUpdate();
			session.getTransaction().commit();
			return rowsUpdated;

		} catch (Exception e) {
			logger.error("Exception in updatePersonalInfoDetails ", e);
		} finally {
			logger.info("Closing session");
			session.close();
		}
		logger.info("End: updatePersonalInfoDetails " + emailId);
		return 0;
	}
	
	@Override
	public int updateLoginCountInPersonalInfoDetails(String emailId, String password,int loginCount) {
		logger.info("Start: updateLoginCountInPersonalInfoDetails " + emailId);
		Session session = factory.openSession();
		try {
			logger.info("Start: updateLoginCountInPersonalInfoDetails method in LoginDAOImpl " + emailId);
			logger.info("Factory " + factory);

			session.beginTransaction();
			// STEP1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("updateLoginCountInPersonalInfoDetails");
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			query.setParameter("loginCount", loginCount);
			// STEP 2: PROCESS
			int rowsUpdated = query.executeUpdate();
			session.getTransaction().commit();
			return rowsUpdated;

		} catch (Exception e) {
			logger.error("Exception in updateLoginCountInPersonalInfoDetails ", e);
		} finally {
			logger.info("Closing session");
			session.close();
		}
		logger.info("End: updateLoginCountInPersonalInfoDetails " + emailId);
		return 0;
	}

	@Override
	public PersonalInfoENTITY fetchPersonalDetailsByEmailIdAndPassword(String emailId, String password) {
		Session session = this.factory.openSession();
		try {
			System.out.println("START : fetchPersonalDetailsByEmailIdAndPassword " + emailId);

			// STEP 1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("fetchPersonalDetailsByEmailIdAndPassword");
			System.out.println("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to RegistrationDTO Object");
			Object result = query.uniqueResult();
			PersonalInfoENTITY entity = (PersonalInfoENTITY) result;
			return entity;

		} catch (HibernateException he) {
			System.err.println(
					"=======> Hibernate Exception in fetchPersonalDetailsByEmailIdAndPassword " + he.getMessage() + he);
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("END : fetchPersonalDetailsByEmailIdAndPassword " + emailId);
		return null;
	}

	@Override
	public VisitingDetailsENTITY fetchVisitingDetailsByEmailIdAndPassword(String emailId, String password) {
		Session session = this.factory.openSession();
		try {
			System.out.println("START : fetchVisitingDetailsByEmailIdAndPassword " + emailId);

			// STEP 1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("fetchVisitingDetailsByEmailIdAndPassword");
			System.out.println("Personal info QUERY---->" + query);
			query.setParameter("emailId", emailId);
			query.setParameter("password", password);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to RegistrationDTO Object");
			Object result = query.uniqueResult();
			VisitingDetailsENTITY entity = (VisitingDetailsENTITY) result;
			return entity;

		} catch (HibernateException he) {
			System.err.println(
					"=======> Hibernate Exception in fetchVisitingDetailsByEmailIdAndPassword " + he.getMessage() + he);
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("END : fetchVisitingDetailsByEmailIdAndPassword " + emailId);
		return null;
	}

	@Override
	public String fetchPasswordByEmailId(String emailId) {
		Session session = this.factory.openSession();
		try {
			System.out.println("START : fetchPasswordByEmailId " + emailId);

			// STEP 1: CREATE FROM DTO USING NAMEDQUERY
			Query query = session.getNamedQuery("fetchPasswordByEmailId");
			System.out.println("Password QUERY---->" + query);
			query.setParameter("emailId", emailId);
			// STEP 2: PROCESS
			logger.info("Getting unique result and casting to RegistrationDTO Object");
			Object result = query.uniqueResult();
			String entity = (String) result;
			return entity;

		} catch (HibernateException he) {
			System.err.println(
					"=======> Hibernate Exception in fetchPasswordByEmailId " + he.getMessage() + he);
		} finally {
			System.out.println("Session closed");
			session.close();
		}
		System.out.println("END : fetchPasswordByEmailId " + emailId);
		return null;
	}

}