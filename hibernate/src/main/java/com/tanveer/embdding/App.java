package com.tanveer.embdding;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		System.out.println("Hibernate Embedding ObjectsL...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Address address = new Address();
		address.setCity("Pune");
		address.setUnitNo("A-123");
		address.setState("Maharashtra");
		address.setStreetName("Koregan Park");

		HouseOwner owner = new HouseOwner();
		owner.setAddress(address);
		owner.setHouseOwnerName("Anil");
		
		session.save(owner);
		
		System.out.println("Done");
	}

}
