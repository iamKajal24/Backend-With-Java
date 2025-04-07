package com.pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernatelearn.Student;

public class HQLPagination {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Query<Student> query = session.createQuery("from Student");

		// implementing pegination using hibernate
		query.setFirstResult(10); // first row
		query.setMaxResults(10); // kitne element chahiye

		List<Student> list = query.list();

		for (Student s : list) {
			System.out.println(s.getId() + " : " + s.getName() + " : " + s.getCity() + " : " + s.getCerti());
		}

		session.close();
		factory.close();

	}
}
