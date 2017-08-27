package com.tanveer.transactionManagement;

import java.util.List;

import org.hibernate.Session;

import com.tanveer.association.withAnnotation.manyToMany.Student;

public class App {
	
	public static void main(String[] args) {
		
		Callable statemnts = new Callable() {
			@Override
			public void call(Session session) {
				List<Student> students = (List<Student>) session.createQuery(" from Student where studentName='Anil'").list();
				System.out.println(students.size());
			}
		};
		
		TransactionManager.execute(statemnts);
	}

}


