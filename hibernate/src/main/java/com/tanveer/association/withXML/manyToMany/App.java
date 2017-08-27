package com.tanveer.association.withXML.manyToMany;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Author a1 = new Author();
		a1.setAuthorName("Sydeny Shyldon");
		
		Author a2 = new Author();
		a2.setAuthorName("Premchand");

		Book b1 = new Book();
		b1.setBookName("Sky is Falling");
		
		Book b2 = new Book();
		b2.setBookName("Swabhimaan");
		
		
		a1.getBooks().add(b1);
		a1.getBooks().add(b2);
		
		a2.getBooks().add(b1);
		a2.getBooks().add(b2);
		
		session.save(a1);
		session.save(a2);
		
		session.getTransaction().commit();
		System.out.println("Done");
	}
}
