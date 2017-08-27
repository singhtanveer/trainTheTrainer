package com.tanveer.CRUD.getLoad;

import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.DataUtil;
import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate HQL...");
		DataUtil.populateData();

		Session session = HibernateUtil.getSessionFactory().openSession();
		
		Student student = (Student) session.createQuery("from Student where studentName='Anil'").list().get(0);
		int id = student.getStudentId();

		student = (Student) session.get(Student.class,id);
		System.out.println("0");
		System.out.println(student.getStudentName());
		System.out.println("1");
		student = (Student) session.load(Student.class,id+1);
		System.out.println("2");
		System.out.println(student.getStudentName());

		session.close();
		System.out.println("Done");
	}

}
