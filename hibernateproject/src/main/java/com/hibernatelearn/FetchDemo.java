package com.hibernatelearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		// get-student:104
		Student student = (Student) session.get(Student.class, 104);
		System.out.println(student);

		// load
		Address address = (Address) session.load(Address.class, 2);
		System.out.println(address.getCity());

		session.close();
		factory.close();
	}

}
