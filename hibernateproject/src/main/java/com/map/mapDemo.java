package com.map;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class mapDemo {

	public static void main(String[] args) {

		// Hibernate configuration
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		// Creating Question object
		Question question = new Question();
		question.setQuestionId(101);
		question.setQuestion("What is Java?");

//      Question question1 = new Question();
//      question1.setQuestionId(109);
//      question1.setQuestion("What is Collection Framework?");

		// Creating Answer objects
		Answer answer1 = new Answer();
		answer1.setAnswerId(234);
		answer1.setAnswer("Java is an Object-Oriented Programming language.");
		answer1.setQuestion(question);

		Answer answer2 = new Answer();
		answer2.setAnswerId(1234);
		answer2.setAnswer("With Java, we can create software.");
		answer2.setQuestion(question);

		Answer answer3 = new Answer();
		answer3.setAnswerId(12341);
		answer3.setAnswer("Java has different types of frameworks.");
		answer3.setQuestion(question);

		// One-to-Many relationship (Adding answers to the question)
		List<Answer> list = new ArrayList<>();
		list.add(answer1);
		list.add(answer2);
		list.add(answer3);
		question.setAnswers(list);

//      question.setAnswer(answer);  // One-to-One mapping 
//      question1.setAnswer(answer1);  // One-to-One mapping 

		// Open Hibernate session
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		// Saving objects
	//	session.save(question); // CascadeType.ALL will automatically save answers

     // session.save(question1);  // Uncomment if needed
		
//		session.save(answer1);
//		session.save(answer2);
//		session.save(answer3);

		tx.commit();

		// Fetching data->
		// one to one->fetch
      Question q = (Question) session.get(Question.class, 101);
      System.out.println(q.getQuestionId());
      System.out.println(q.getQuestion());
      System.out.println(q.getAnswers().size());
//      System.out.println(q.getAnswer().getAnswer());

		// one to many->fetch
//		Question q = (Question) session.get(Question.class, 101);
//		System.out.println(q.getQuestion());
//		for (Answer a : q.getAnswers()) {
//			System.out.println(a.getAnswer());
//		}

		session.close();
		factory.close();

		System.out.println("✅ Data saved successfully!");
	}
}
