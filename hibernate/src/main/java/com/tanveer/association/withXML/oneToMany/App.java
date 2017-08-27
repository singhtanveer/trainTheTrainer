package com.tanveer.association.withXML.oneToMany;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		System.out.println("Hibernate one to many (XML)");
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		City city1 = new City();
		city1.setCityName("Mumbai");
		
		City city2 = new City();
		city2.setCityName("Pune");
		
		State state = new State();
		state.setStateName("Maharashtra");
		state.setStateArea(1.25f);
		
		city1.setState(state);
		city2.setState(state);
		state.getCities().add(city1);
		state.getCities().add(city2);
		
		session.save(state);
		session.save(city1);
		session.save(city2);
		
		session.getTransaction().commit();
		System.out.println("Done");
	}
}
