package com.tanveer.inheritance.withAnnotation.singleTableStrategy;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Shape shape = new Shape();
		shape.setShapeName("2D");
		
		Square square = new Square();
		square.setShapeName("Linear");
		square.setArea("a*a");
		
		Circle circle = new Circle();
		circle.setShapeName("Round");
		circle.setVolumne("r3");
		
		session.save(shape);
		session.save(square);
		session.save(circle);
		
		session.getTransaction().commit();
	}
}
