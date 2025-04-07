package com.firstcache;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatelearn.Student;

public class FirstDemo {
	
	public static void main(String[] args) {
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();
		
		//by default enabled
		Student student  = session.get(Student.class,11);
		System.out.println(student);
		System.out.println("working something....");
		Student student2 =session.get(Student.class, 11);
		System.out.println(student2);
		
		System.out.println(session.contains(student2));
		session.close();
		factory.close();
	}

}
