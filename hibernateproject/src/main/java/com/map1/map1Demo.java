package com.map1;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class map1Demo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

		Employee employee = new Employee();
		Employee employee2 = new Employee();

		employee.setId(34);
		employee.setEmp("Rahul");

		employee2.setId(56);
		employee2.setEmp("Shyam");

		Project p1 = new Project();
		Project p2 = new Project();

		p1.setProject_id(1);
		p1.setProjectName("Library management System");

		p2.setProject_id(2);
		p2.setProjectName("ChatBot applications");

		List<Employee> emplist = new ArrayList<Employee>();
		emplist.add(employee);
		emplist.add(employee2);

		List<Project> projectList = new ArrayList<Project>();
		projectList.add(p1);
		projectList.add(p2);

		employee.setProjects(projectList);
		p2.setEmps(emplist);

		Session session = factory.openSession();
		Transaction tx = session.beginTransaction();

		session.save(employee);
		session.save(employee2);
		session.save(p1);
		session.save(p2);

		tx.commit();
		session.close();
		factory.close();
		
		System.out.println("✅ Data saved successfully!");

	}

}
