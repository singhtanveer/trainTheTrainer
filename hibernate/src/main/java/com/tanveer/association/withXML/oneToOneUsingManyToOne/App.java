package com.tanveer.association.withXML.oneToOneUsingManyToOne;

import java.util.Date;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to one using many to one (with XML)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Driver driver = new Driver();
		driver.setDriverName("Anil");
		
		License license = new License();
		license.setIssueDate(new Date());
		license.setLicenseNo("A12345");

		driver.setLicense(license);
		license.setDriver(driver);
		
		session.save(driver);
		session.save(license);
		
		session.getTransaction().commit();

		System.out.println("Done");
	}
}
