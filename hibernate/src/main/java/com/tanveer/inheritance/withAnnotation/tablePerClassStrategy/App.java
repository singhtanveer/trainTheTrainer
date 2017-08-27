package com.tanveer.inheritance.withAnnotation.tablePerClassStrategy;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Calculation calculation = new Calculation();
		calculation.setCalculationName("Calculator");
		
		Addition addition = new Addition();
		addition.setCalculationName("plus");
		addition.setCalculationMethod("a+b");
		
		Subtraction subtraction = new Subtraction();
		subtraction.setCalculationMethod("a-b");
		subtraction.setCalculationName("minus");
		
		session.save(calculation);
		session.save(addition);
		session.save(subtraction);
		
		session.getTransaction().commit();
		session.close();
	}
}
