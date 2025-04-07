package com.hql;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernatelearn.Student;

public class HQLExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		// HQL SELECT with parameters
		String query = "from Student as s where s.city = :x and s.name = :y";

		Query<Student> q = session.createQuery(query, Student.class);
		q.setParameter("x", "Gujrat");
		q.setParameter("y", "khushi");

		List<Student> list = q.list();

		for (Student student : list) {
			System.out.println(student.getName() + " : " + student.getCerti());
		}

		System.out.println("______________________________________");

		// HQL DELETE query (correct entity name used)
		Transaction tx = session.beginTransaction();

		// Delete Query
//        String query2 = "delete from Student as s where s.city = :c"; //  Correct entity name
//        Query q2 = session.createQuery(query2);
//        q2.setParameter("c", "Haridwar");

//        int r = q2.executeUpdate();
//        System.out.println("Deleted: " + r + " rows");

		// Update Query
//       // Update Query
		Query q2 = session.createQuery("update Student set city = :c where name = :n");
		q2.setParameter("c", "Delhi");
		q2.setParameter("n", "Peter");

		int r = q2.executeUpdate();
		System.out.println("Updated : " + r + " rows");

		tx.commit();

		// how to execute join query
		Query<Object[]> q3 = session.createQuery(
	            "select q.question, q.questionId, a.answer from Question q INNER JOIN q.answers a",
	            Object[].class
	        );

	        List<Object[]> list3 = q3.getResultList();
	        for (Object[] arr : list3) {
	            System.out.println(Arrays.toString(arr));
	        }
		
		session.close();
		factory.close();
	}
}
