package com.tanveer.CRUD.savePersist;

import java.sql.SQLException;

import org.hibernate.ReplicationMode;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.engine.SessionFactoryImplementor;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) throws SQLException {
		System.out.println("Hibernate HQL...");

		System.out.println("Isolation Level -> " + ((SessionFactoryImplementor)HibernateUtil.getSessionFactory()).getConnectionProvider().getConnection().getTransactionIsolation());

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		SQLQuery createSQLQuery = session.createSQLQuery("delete from student");
		createSQLQuery.executeUpdate();
		session.getTransaction().commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		Student s1 = new Student();
		s1.setStudentName("Tanveer");
		session.save(s1);
		session.evict(s1);
		session.replicate(s1,ReplicationMode.LATEST_VERSION);
		s1.setStudentName("TanveerNew");
		Integer studentId = s1.getStudentId();
		System.out.println(studentId);
		session.getTransaction().commit();
		session.close();

		session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		System.out.println(((Student)session.load(Student.class, studentId)).getStudentName());
		
		
		session.getTransaction().commit();
		session.close();

	
		
	
	
	
	}

}
