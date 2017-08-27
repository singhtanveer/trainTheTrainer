package com.tanveer.inheritance.withXML.tablePerClassStrategy;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Appliance appliance = new Appliance();
		appliance.setApplianceName("Gadget");
		
		Television television = new Television();
		television.setApplianceName("Samsung");
		television.setFunction("Watch movies");
		television.setSize("32 inches");
		
		WaterPurifier wp = new WaterPurifier();
		wp.setApplianceName("Aquagard");
		wp.setFunction("Purifiy Water");
		wp.setCapacity("5 litre");
		
		session.save(appliance);
		session.save(wp);
		session.save(television);
		
		session.getTransaction().commit();
	}
}
