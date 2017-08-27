package com.tanveer.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.DataUtil;
import com.tanveer.util.HibernateUtil;

public class NamedQuery {
	public static void main(String[] args) {
		System.out.println("Hibernate Named Query HQL...");
		DataUtil.populateData();

		Session session = HibernateUtil.getSessionFactory().openSession();

		System.out.println("-----------------------  NamedQuery  ------------------------");
		Query query = session.getNamedQuery("studentById");
		query.setInteger(0, 4);
		List<Student> students = (List<Student>) query.list();
		System.out.println(students.size());
		
		
		
		System.out.println("-----------------------  NamedNativeQuery  ------------------------");
		query = session.getNamedQuery("studentByName");
		query.setString(0, "Akshay");
		students = (List<Student>) query.list();
		System.out.println(students.size());
		
		session.close();
		System.out.println("Done");
	}

}
