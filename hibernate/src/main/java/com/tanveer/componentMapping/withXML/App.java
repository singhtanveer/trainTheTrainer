package com.tanveer.componentMapping.withXML;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate bag using XML...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		Engine engine = new Engine();
		engine.setEngineCapacity("800cc");
		engine.setEngineType("petrol");
		
		Car car = new Car();
		car.setCarName("Alto");
		car.setEngine(engine);

		
		Integer carID = (Integer) session.save(car);

		System.out.println("carID: " + carID);
		
		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}

}
