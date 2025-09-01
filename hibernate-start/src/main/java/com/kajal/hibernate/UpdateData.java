package com.kajal.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class UpdateData {

	public static void main(String[] args) {
		System.out.println("Hello World!");

		Student s1 = new Student();
		s1.setRollNo(105);
		s1.setsName("lakshmi Chauhan");
		s1.setsAge(28);

		Student s2 = null;

		SessionFactory sFactory = new Configuration().addAnnotatedClass(com.kajal.hibernate.Student.class).configure()
				.buildSessionFactory(); // cfg.buildSessionFactory();

		Session session = sFactory.openSession();

		// fatch data
		s2 = session.get(Student.class, 106);

		// updated data

		Transaction transaction = session.beginTransaction();

		session.merge(s1);

		transaction.commit();

		session.close();
		sFactory.close();

		System.out.println(s2);
		System.out.println("project completed");
	}

}
