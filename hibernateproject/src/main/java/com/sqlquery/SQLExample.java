package com.sqlquery;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;

import com.hibernatelearn.Student;

public class SQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		// SQL query
		String query = "select * from Student";

		NativeQuery nq = session.createSQLQuery(query);

		List<Object[]> list = nq.list();
		for (Object[] student : list) {
//			System.out.println(Arrays.toString(student));
			System.out.println(student[4] + " : " + student[3]);
		}

		session.close();
		factory.close();
	}

}
