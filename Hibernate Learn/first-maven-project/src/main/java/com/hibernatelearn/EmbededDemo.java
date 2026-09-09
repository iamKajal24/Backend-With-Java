package com.hibernatelearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class EmbededDemo {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        Student student = new Student();
        student.setId(101);
        student.setName("Shubham Chauhan");
        student.setCourse("IT");
        student.setCity("Noida");

        Cirtificate cirtificate = new Cirtificate();
        cirtificate.setCourse_name("MCA");
        cirtificate.setDuration("2 years");
        student.setCerti(cirtificate);

        Student student1 = new Student();
        student1.setId(102);
        student1.setName("Kajal");
        student1.setCourse("IT");
        student1.setCity("Delhi");

        Cirtificate cirtificate1 = new Cirtificate();
        cirtificate1.setCourse_name("B.Tech");
        cirtificate1.setDuration("4 years");
        student1.setCerti(cirtificate1);

        Transaction transaction = session.beginTransaction();

        
        //save
        session.save(student);
        session.save(student1);

        
        transaction.commit();
        session.close();
        sessionFactory.close();

    }

}
