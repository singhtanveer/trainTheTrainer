package com.tanveer.association.withXML.oneToOne;

import java.util.Date;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (with XML)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Person pn = new Person();
		pn.setFirstName("Tanveer");
		pn.setLastName("Singh");

		Passport pt = new Passport();
		pt.setPassportNo("A12345");
		pt.setIssueDate(new Date());

		pt.setPerson(pn);
		pn.setPassport(pt);
		
		session.save(pn);
		session.getTransaction().commit();
		
//		Passport passport = (Passport) session.load(Passport.class, 1);
//		System.out.println(passport.getPerson());

		System.out.println("Done");
	}
}
