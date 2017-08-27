package com.tanveer.inheritance.withAnnotation.tablePerConcreteClassStrategy;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Lion lion = new Lion();
		lion.setAnimalName("Sheru");
		lion.setRoar("grrrrr");
		
		Horse horse = new Horse();
		horse.setAnimalName("ghoda");
		horse.setNeigh("eeeeehhhhhh");
		
		session.save(lion);
		session.save(horse);
		
		session.getTransaction().commit();
		session.close();
	}
}
