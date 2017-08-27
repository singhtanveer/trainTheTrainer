package com.tanveer.inheritance.withXML.singleTableStrategy;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Worker worker = new Worker();
		worker.setWorkerName("Employee");
		
		FullTime fullTiime = new FullTime();
		fullTiime.setWorkerName("Ajay");
		fullTiime.setPerks("Bonus");
		fullTiime.setHours(8);
		
		Contractor contractor = new Contractor();
		contractor.setWorkerName("Akshay");
		contractor.setWages(20000);
		contractor.setHours(8);
		
		Intern intern = new Intern();
		intern.setWorkerName("Sunil");
		intern.setStipend(5000);
		intern.setHours(6);
		
		session.save(worker);
		session.save(fullTiime);
		session.save(contractor);
		session.save(intern);
		
		session.getTransaction().commit();
	}
}
