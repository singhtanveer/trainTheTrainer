package com.tanveer.collections.withXML.listOfString;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.tanveer.util.HibernateUtil;

public class App {
	public static void main(String[] args) {

		System.out.println("Hibernate bag using XML...");

		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		List<String> answers = new ArrayList<String>();
		answers.add("Java");
		answers.add("Oracle");

		Question question = new Question();
		question.setQuestionName("Which certifications you have?");;
		question.setAnswers(answers);
		Integer questionID = (Integer) session.save(question);
		System.out.println("questionID: " + questionID);
		
		
		answers = new ArrayList<String>();
		answers.add("Bangalore");
		answers.add("Hyderabad");
		
		question = new Question();
		question.setQuestionName("Which places you have visited?");;
		question.setAnswers(answers);
		questionID = (Integer) session.save(question);
		System.out.println("questionID: " + questionID);
		
		answers = new ArrayList<String>();
		answers.add("Red");
		answers.add("Blue");
		answers.add("Green");
		
		question = new Question();
		question.setQuestionName("Which is your favourite color?");;
		question.setAnswers(answers);
		questionID = (Integer) session.save(question);
		System.out.println("questionID: " + questionID);
		
		session.getTransaction().commit();
		session.close();

		System.out.println("Done");
	}

}
