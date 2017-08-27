package com.tanveer.collections.withXML.bag;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate bag using XML...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		List<Certificate> cert = new ArrayList<Certificate>();
		cert.add(new Certificate("MCA"));
		cert.add(new Certificate("MBA"));
		cert.add(new Certificate("PMP"));

		Applicant applicant = new Applicant();
		applicant.setApplicantName("Anil");
		applicant.setCertificates(cert);
		Integer applicantID = (Integer) session.save(applicant);

		System.out.println("applicantID: " + applicantID);
		
		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}

}
