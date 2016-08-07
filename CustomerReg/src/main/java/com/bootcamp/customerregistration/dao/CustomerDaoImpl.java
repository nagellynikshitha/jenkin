package com.bootcamp.customerregistration.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bootcamp.customerregistration.model.Customer;

@Repository
public class CustomerDaoImpl implements CustomerDao {

	private static final Logger logger = LoggerFactory.getLogger(CustomerDaoImpl.class);

	@Autowired
	private SessionFactory sessionFactory;

	@Override

	public String addCustomer(Customer cust) {

		System.out.println(cust.toString());
		Session session = sessionFactory.getCurrentSession();
		session.persist(cust);
		logger.info("Person saved successfully, Person Details=" + cust);
		System.out.println(cust);
	
		return "Customer Register Sucessfully" + cust;


	}

	@Override
	public int getCustomerid(Customer cust) {

		Session session = (Session) sessionFactory.openSession();

		Query q1 = session.createQuery("Select id from Customer where email=:uemail");
		q1.setString("uemail", cust.getEmail());
		List result = q1.list();
		int cid = 0;

		if (result.size() != 0) {
			cid = (Integer) result.get(0);
			// String cid= custId;
			System.out.println(cid);

		}

		logger.info("id saved successfully");
		return cid;
	}

/*	@Override
	public  Customer getCustomerByid(int id) {
		
		SessionFactory sessionFactory = new Configuration().configure(
				"/WEB-INF/hibernate.cfg.xml")
				.buildSessionFactory();
		
		 Session session= sessionFactory.openSession();

		//Session session = (Session) sessionFactory.getCurrentSession();
		System.out.println("before query");

		Query q1 = session.createQuery(" from Customer where cid=:uid");
		q1.setParameter("uid", id);
		//List result = q1.list();
		Customer result = (Customer) q1.uniqueResult();
		//int cid = 0;
		

		System.out.println("in dao");
		
			return result;

	
	
		
	}
*/

	

}
