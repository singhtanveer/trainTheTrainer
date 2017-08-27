package com.tanveer.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tanveer.util.DataUtil;
import com.tanveer.util.HibernateUtil;

public class Pagination {
	public static void main(String[] args) {
		System.out.println("Hibernate Pagination HQL...");
		DataUtil.populateData();

		Session session = HibernateUtil.getSessionFactory().openSession();

		Query query = session.createQuery("select studentName from Student");
		query.setFirstResult(0);
		query.setMaxResults(6);
		List<String> names = (List<String>) query.list();
		System.out.println(names.size());
		for(String name : names){
			System.out.println(name);
		}
		
		session.close();
		System.out.println("Done");
	}

}
