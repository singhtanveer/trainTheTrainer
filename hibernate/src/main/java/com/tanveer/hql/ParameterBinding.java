package com.tanveer.hql;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;
import com.tanveer.util.DataUtil;
import com.tanveer.util.HibernateUtil;

public class ParameterBinding {
	public static void main(String[] args) {
		System.out.println("Hibernate HQL...");
		DataUtil.populateData();

		/*	Below code can lead to sql injction attack
		String num = "5 or 1=1";
		session.createQuery("select studentId, studentName from Student where studentId > " + num);
		so solution is sql binding*/
		
		Session session = HibernateUtil.getSessionFactory().openSession();

		System.out.println("-----------------------  Parameter Binding using positional placeholer ------------------------");
		Query query = session.createQuery("from Student where studentId > ?");
		query.setInteger(0, 6);
		List<Student> students = (List<Student>) query.list();
		System.out.println(students.size());
		
		
		System.out.println("-----------------------  Parameter Binding using name placeholer ------------------------");
		query = session.createQuery("from Student where studentId > :range");
		//query.setInteger("range", 6)
		query.setParameter("range", 6)
		.setComment("+ INDEX(stock idx_stock_code)");
		
		students = (List<Student>) query.list();
		System.out.println(students.size());
			
		session.close();
		System.out.println("Done");
	}

}
