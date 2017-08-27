package com.tanveer.hql;

import java.util.List;
import java.util.Map;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.DataUtil;
import com.tanveer.util.HibernateUtil;
import org.hibernate.criterion.Restrictions;

public class Restriction {
	public static void main(String[] args) {
		System.out.println("Hibernate restricton criteria just like where class...");
		DataUtil.populateData();

		Session session = HibernateUtil.getSessionFactory().openSession();

//		System.out.println("--------------------------  simple criteria using like -------------------------------------------------------");
//		Criteria criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.like("studentName", "Sun%"));
//		
//		List<Student> list = (List<Student>) criteria.list();
//
//		for(Student student : list){
//			System.out.println(student.getStudentId() + "-" + student.getStudentName());
//		}
		
		System.out.println("--------------------  simple criteria using more adds and gt eq etc.. -------------------------------------------------------");
		Criteria criteria = session.createCriteria(Student.class);
		criteria.add(Restrictions.lt("studentId", 3))
		.add(Restrictions.between("studentId", 7, 9))
		.add(Restrictions.eq("studentName", "Shahrukh"));
		
		List<Student> list = (List<Student>) criteria.list();

		for(Student student : list){
			System.out.println(student.getStudentId() + "-" + student.getStudentName());
		}
		
//		System.out.println("--------------------------  simple criteria using or condition -------------------------------------------------------");
//		criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.or(Restrictions.like("studentName", "Sun%"), Restrictions.eq("studentId", 5)));
//		
//		System.out.println("--------------------------  simple criteria using and condition -------------------------------------------------------");
//		criteria = session.createCriteria(Student.class);
//		criteria.add(Restrictions.and(Restrictions.like("studentName", "Sh%"), Restrictions.eq("studentId", 1)));
//		
//		list = (List<Student>) criteria.list();
//
//		for(Student student : list){
//			System.out.println(student.getStudentId() + "-" + student.getStudentName());
//		}
		
		session.close();
	}

}
