package com.tanveer.collections.withXML.map;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate map of string using XML...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();


		Portal portal = new Portal();
		
		portal.getUsers().put("Akshay Kumar", new Credentials("aKumar1950", "shine123", "Where were you born?", "Punjab"));
		portal.getUsers().put("Ajay Devgan", new Credentials("ajyD1956", "star456", "What is your birth year?" ,"1956"));
		portal.getUsers().put("Sunil Shetty", new Credentials("sShetty", "moon789", "Which is your favourite color?", "Red"));
		
		portal.setPortalName("Flipkarte");
		Integer portalID = (Integer) session.save(portal);

		System.out.println("portalID: " + portalID);
		
		
		
		portal = new Portal();
		
		portal.getUsers().put("Salman Khan", new Credentials("sKhan1950", "shine123", "Where were you born?", "UP"));
		portal.getUsers().put("Shahrukh Khan", new Credentials("sharukhK1956", "star456", "What is your birth year?" ,"1956"));
		portal.getUsers().put("Amir Khan", new Credentials("aKhan", "moon789", "Which is your favourite color?", "Blue"));
		
		portal.setPortalName("Amazon");
		portalID = (Integer) session.save(portal);

		System.out.println("portalID: " + portalID);
		
		
		
		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}
	
/*	SELECT * FROM portal;
	SELECT * FROM users;
	SELECT * FROM credential;
	
	SELECT a.*,b.userName,c.* FROM portal a, users b, credential c
	WHERE a.portalId=b.portals_Id AND
	b.credentialId=c.credentialId;*/

}
