package com.tanveer.collections.withAnnotation.elemntCollecton;

import org.hibernate.Session;

import com.tanveer.embdding.Address;
import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		System.out.println("Hibernate Embedding ObjectsL...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Address address1 = new Address();
		address1.setCity("Chennai");
		address1.setUnitNo("B-123");
		address1.setState("Tamil Nadu");
		address1.setStreetName("Hi-Tec City");
		
		Address address2 = new Address();
		address2.setCity("Banglore");
		address2.setUnitNo("C-456");
		address2.setState("Karnataka");
		address2.setStreetName("Electronic City");
		
		Company company = new Company();
		company.setCompanyName("Cognizant");
		company.getAddressees().add(address2);
		company.getAddressees().add(address1);
		
		session.save(company);
		
		session.getTransaction().commit();
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		
		company = null;
		
		company = (Company) session.get(Company.class, 4);
		System.out.println("getting addresses...");
		
		session.close();
		System.out.println(company.getAddressees().size());
		
		
		System.out.println("Done");
	}

}
