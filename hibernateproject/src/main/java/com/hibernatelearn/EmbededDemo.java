package com.hibernatelearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbededDemo {
	
	public static void main(String[] args) {
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Student st = new Student();
		st.setId(105);
		st.setName("RAM");
		st.setCity("DEHRADUN");
		
		Certificate certificate = new Certificate();
		certificate.setCourse("JAVA");
		certificate.setDuration("3 MONTHS");

		st.setCerti(certificate);
		
		Student st1 = new Student();
		st1.setId(108);
		st1.setName("RIYA");
		st1.setCity("GUJRAT");
		
		Certificate certificate1 = new Certificate();
		certificate1.setCourse("SPRINGBOOT");
		certificate1.setDuration("2 MONTHS");

		st1.setCerti(certificate1);
		
		Session session = factory.openSession();
		Transaction tx =session.beginTransaction();
		
		//object save
		session.save(st);
		session.save(st1);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
