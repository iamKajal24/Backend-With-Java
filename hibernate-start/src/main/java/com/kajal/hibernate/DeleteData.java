package com.kajal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeleteData {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		Student s1 = null;

		SessionFactory sFactory = new Configuration().addAnnotatedClass(com.kajal.hibernate.Student.class).configure()
				.buildSessionFactory(); // cfg.buildSessionFactory();

		Session session = sFactory.openSession();

	    //delete data
		
		s1 = session.get(Student.class, 101);

		Transaction transaction = session.beginTransaction();

		session.remove(s1);

		transaction.commit();

		session.close();
		sFactory.close();

		System.out.println(s1);
		System.out.println("project completed");
	}

}
