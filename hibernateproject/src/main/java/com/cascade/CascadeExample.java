package com.cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.map.Answer;
import com.map.Question;

public class CascadeExample {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session session = factory.openSession();

		Question q1 = new Question();
		q1.setQuestionId(567);
		q1.setQuestion("What is cascading");

		Answer a1 = new Answer();
		a1.setAnswerId(2345);
		a1.setAnswer("In hibernate it is important concept");

		Answer a2 = new Answer();
		a2.setAnswerId(23450);
		a2.setAnswer("Second answer");

		Answer a3 = new Answer();
		a3.setAnswerId(23451);
		a3.setAnswer("Third answer");

		List<Answer> list = new ArrayList<Answer>();
		list.add(a1);
		list.add(a2);
		list.add(a3);

		q1.setAnswers(list);
		Transaction tx = session.beginTransaction();
		
		session.save(q1);
		session.save(a1);
		session.save(a2);
		session.save(a3);
		
		tx.commit();
		session.close();
		factory.close();
	}

}
