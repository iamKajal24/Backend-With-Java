package com.kajal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Hello World!");

		Student s1 = new Student();
		s1.setRollNo(107);
		s1.setsName("Himani Joshi");
		s1.setsAge(23);
		
		Student s2 = new Student();
		s2.setRollNo(108);
		s2.setsName("Subham Chauhan");
		s2.setsAge(29);

//        Configuration cfg = new Configuration();
//        cfg.addAnnotatedClass(com.kajal.hibernate.Student.class);
//        cfg.configure();

		SessionFactory sFactory = new Configuration().addAnnotatedClass(com.kajal.hibernate.Student.class).configure()
				.buildSessionFactory(); // cfg.buildSessionFactory();

		Session session = sFactory.openSession();

		Transaction transaction = session.beginTransaction();

		// fatch data
		//s2 = session.get(Student.class, 105);

		// save data
		// session.save(s1) ;

		session.persist(s1);
		session.persist(s2);
		
		transaction.commit();
		session.close();
		sFactory.close();

		System.out.println(s1);
		System.out.println(s2);
		System.out.println("project completed");
		
	}
}
