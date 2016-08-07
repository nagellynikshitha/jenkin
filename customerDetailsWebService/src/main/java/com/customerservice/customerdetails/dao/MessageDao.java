package com.customerservice.customerdetails.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.customerservice.customerdetails.model.ServicePlan;
import com.customerservice.customerdetails.util.HIbernateUtil;

public  class MessageDao {

	private HIbernateUtil hibernateUtil;

	public void saveSid(int sid, int cid) {


		SessionFactory sessionfactory = hibernateUtil.getSessionFactory();
		Session session = sessionfactory.openSession();		Transaction tx = session.beginTransaction();

		Query query = session.createQuery("update Customer set sid = :msid" + " where cid = :mcid");
		query.setParameter("msid", sid);
		query.setParameter("mcid", cid);
		int result = query.executeUpdate();
		tx.commit();
		session.close();
		
	}

}
