package com.customerservice.customerdetails.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.customerservice.customerdetails.model.Customer;
import com.customerservice.customerdetails.model.ServicePlan;
import com.customerservice.customerdetails.util.HIbernateUtil;

@Repository
public class ServiceDaoImpl implements ServiceDao {

	private static final Logger logger = LoggerFactory.getLogger(ServiceDaoImpl.class);

	private HIbernateUtil hibernateUtil;

	@Override
	public List<ServicePlan> getServicePlans() {


		SessionFactory sessionfactory = hibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();

		Query q1 = session.createQuery(" from ServicePlan ");

		List l = q1.list();
		

		System.out.println("services" + l.size());
		return l;

	}

	public Customer getCustomerDAO(int c_id) {
		System.out.println("hi rest dao");
		 
		SessionFactory sessionfactory = hibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();
		
		Transaction tx =session.beginTransaction();

		Query query = session.createQuery("from Customer where cid=:id");
		query.setParameter("id", c_id);
		// Service ser=(Service) query.uniqueResult();
		Customer cust = (Customer) query.uniqueResult();
		tx.commit();
		
		System.out.println("cust" + cust);
		session.close();
		return cust;
		
	}

}
