package com.tanveer.association.withAnnotation.manyToMany;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Student s1 = new Student();
		s1.setStudentName("Tanveer");
		
		Student s2 = new Student();
		s2.setStudentName("Anil");

		Course c1 = new Course();
		c1.setCourseName("Chemistry");
		
		Course c2 = new Course();
		c2.setCourseName("Physics");
		
		
		s1.getCourses().add(c1);
		s1.getCourses().add(c2);
		
		s2.getCourses().add(c1);
		s2.getCourses().add(c2);
		
		session.save(s1);
		session.save(s2);
		
		session.getTransaction().commit();
	}
}
