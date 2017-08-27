package com.tanveer.hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.DataUtil;
import com.tanveer.util.HibernateUtil;

public class Hql {
	public static void main(String[] args) {
		System.out.println("Hibernate HQL...");
		DataUtil.populateData();

		Session session = HibernateUtil.getSessionFactory().openSession();

		System.out.println("--------------------------  simple hql  -------------------------------------------------------");
		Query query = session.createQuery("from Student");
		List<Student> list = (List<Student>) query.list();
		System.out.println(list.size());
		
		
		System.out.println("--------------------  select 2 columns - value retreived as list of array  --------------------");
		query = session.createQuery("select studentId, studentName from Student where studentId > 6");
		List<Object[]> values = (List<Object[]>) query.list();
		for(Object[] value : values){
			System.out.println(value[0] + "--" + value[1]);
		}
		
		
		System.out.println("------------  get data as map + condition applied ---------------------------------------------");
		query = session.createQuery("select new map(studentId as id, studentName as name) from Student");
		List<Map<String, Object>> datas = (List<Map<String, Object>>) query.list();
		for(Map<String, Object> value : datas){
			System.out.println(value.get("id") + "--" + value.get("name"));
		}
		
		
//		System.out.println("------------  insert ---------------------------------------------");		
//		query = session.createQuery("insert into Student(studentName) select 'Ranbir'");
//		int result = query.executeUpdate();
//		
		query = session.createQuery("from Student where studentName='Sunny'");
		Student student = (Student)query.list().get(0);
		System.out.println(student.getStudentId() + ":"+ student.getStudentName());
		
		System.out.println("------------  update ---------------------------------------------");		
		session.getTransaction().begin();
		query = session.createQuery("update Student set studentName = :studentName where studentId = :studentId");
		query.setParameter("studentName", "Ranvir");
		query.setParameter("studentId", student.getStudentId());
		int result = query.executeUpdate();
		session.getTransaction().commit();
		session.close();
		
		session = HibernateUtil.getSessionFactory().openSession();
		session.getTransaction().begin();
		query = session.createQuery("from Student where studentName='Ranvir'");
		Student newStudent = (Student)query.list().get(0);
		System.out.println(newStudent.getStudentId() + ":"+ newStudent.getStudentName());
		
		System.out.println("------------  delete ---------------------------------------------");	
//		session.getTransaction().begin();
		query = session.createQuery("delete Student where studentId = " + student.getStudentId());
		result = query.executeUpdate();
		session.getTransaction().commit();
		
		query = session.createQuery("from Student where studentName='Ranvir'");
		System.out.println(query.list().size());
		
		////////////read about result transformer///////////////////////
		session.close();
		System.out.println("Done");
	}

}
