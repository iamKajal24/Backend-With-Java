package com.hibernatelearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {
	
	public static void main(String[] args) {
		
		//practical of hibernate object states:
		//transient
		//persistent
		//Detached
		//Removed
		
		System.out.println("Example :");
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		//creating student object
		Student student = new Student();
		student.setId(1414);
		student.setName("Riya");
		student.setCity("Gujrat");
		student.setCerti(new Certificate("java Hibernate course","2 month"));
		//student:Transient
		
		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();
		session.save(student);
		//student:  persistent -session,database
		student.setName("Khushi");
		tx.commit();
		
		session.close();
		
		//student : detached
		student.setName("Kajal pandit");
		System.out.println(student);
		
		factory.close();
	}
}
