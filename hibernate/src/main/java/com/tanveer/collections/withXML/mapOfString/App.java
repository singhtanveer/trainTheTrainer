package com.tanveer.collections.withXML.mapOfString;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate map of string using XML...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();


		Marksheet marksheet = new Marksheet();
		
		marksheet.getSubjectMarks().put("Physics", "95");
		marksheet.getSubjectMarks().put("Chemistry", "90");
		marksheet.getSubjectMarks().put("Mathematics", "100");
		marksheet.setStudentName("Anil");
		Integer marksheetID = (Integer) session.save(marksheet);

		System.out.println("marksheetID: " + marksheetID);
		
		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}

}
