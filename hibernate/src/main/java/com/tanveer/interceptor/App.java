package com.tanveer.interceptor;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.tanveer.util.HibernateUtil;

public class App {
	
	public static void main(String[] args) {
		Session session = null;
		   Transaction tx = null;
		   try {

			AuditLogInterceptor interceptor = new AuditLogInterceptor();
			session = HibernateUtil.getSessionFactory().openSession(interceptor);
			
			interceptor.setSession(session);

			tx = session.beginTransaction();
			Shop shopInsert = new Shop();
			shopInsert.setShopName("Archies");
			session.saveOrUpdate(shopInsert);
			tx.commit();

			//test update
			tx = session.beginTransaction();
			Query query = session.createQuery("from Shop where shopName = 'Archies'");
			Shop shopUpdate = (Shop)query.list().get(0);
			shopUpdate.setShopName("7-Eleven");
			session.saveOrUpdate(shopUpdate);
			tx.commit();

			//test delete
			tx = session.beginTransaction();
			session.delete(shopUpdate);
			tx.commit();

		   } catch (RuntimeException e) {
			try {
				tx.rollback();
			} catch (RuntimeException rbe) {
				// log.error("Couldn’t roll back transaction", rbe);
		   }
			throw e;
		   } finally {
			if (session != null) {
				session.close();
			}
		   }
	}

}
