package com.tanveer.cache;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.DataUtil;
import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate HQL...");
//		DataUtil.populateData();

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		System.out.println(0);
		
		Query query = session.createQuery("from Student where studentName='Anil'");
		query.setCacheable(true);
		
		Student student = (Student) query.list().get(0);
		
		int id = student.getStudentId();
		System.out.println(1);
		student = (Student) session.get(Student.class,id);
		System.out.println(2);
		student = (Student) session.get(Student.class,id);
		System.out.println(3);
		session.getTransaction().commit();
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println(4);
		student = (Student) session.get(Student.class,id);
		System.out.println(5);
		session.getTransaction().commit();
		session.close();
		
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println(6);
		query = session.createQuery("from Student where studentName='Anil'");
		query.setCacheable(true);
		student = (Student) query.list().get(0);
		System.out.println(7);
		session.getTransaction().commit();
		session.close();
		
		
		
		System.out.println("Done");
	}

}
