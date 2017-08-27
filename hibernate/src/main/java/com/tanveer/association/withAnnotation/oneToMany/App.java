package com.tanveer.association.withAnnotation.oneToMany;

import java.util.Date;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (Annotation)");
		Session session = HibernateUtil.getSessionFactory().openSession();

		session.beginTransaction();

		Employer employer = new Employer();
		
		Employee emp1 = new Employee();
		emp1.setEmployeeName("Tanveer");
		emp1.setJoiningDate(new Date());
		emp1.setEmployer(employer);
		
		Employee emp2 = new Employee();
		emp2.setEmployeeName("Singh");
		emp2.setJoiningDate(new Date());
		emp2.setEmployer(employer);
		
		employer.setEmployerName("Cognizant");
		employer.setEmployerType("IT");
		employer.getEmployee().add(emp1);
		employer.getEmployee().add(emp2);
		
		session.save(employer);
		session.save(emp1);
		session.save(emp2);
		
		session.getTransaction().commit();

		System.out.println("Done");
	}
}
