package com.tanveer.util;

import org.hibernate.SQLQuery;
import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.HibernateUtil;

public class DataUtil {
	
	public static void populateData() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		SQLQuery createSQLQuery = session.createSQLQuery("delete from student_course");
		createSQLQuery.executeUpdate();
		createSQLQuery = session.createSQLQuery("delete from student");
		createSQLQuery.executeUpdate();
		
		Student s1 = new Student();
		s1.setStudentName("Tanveer");
		session.save(s1);
		s1.setStudentName("Anil");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Sunny");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Shahid");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Sunil");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Akshay");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Ajay");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Sanjay");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Saif");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Salman");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Shahrukh");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Amir");
		session.save(s1);
		s1 = new Student();
		s1.setStudentName("Irfaan");
		session.save(s1);
		session.getTransaction().commit();
		session.close();
	}

}
