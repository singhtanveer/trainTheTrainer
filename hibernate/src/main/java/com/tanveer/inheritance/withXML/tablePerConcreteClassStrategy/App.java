package com.tanveer.inheritance.withXML.tablePerConcreteClassStrategy;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Chair chair= new Chair();
		chair.setChairType("ArmChair");
		chair.setFurnitureName("Maharaja");
		
		Table table = new Table();
		table.setTableType("Center table");
		table.setFurnitureName("RoundTable");
		
		session.save(chair);
		session.save(table);
		
		session.getTransaction().commit();
	}
}
