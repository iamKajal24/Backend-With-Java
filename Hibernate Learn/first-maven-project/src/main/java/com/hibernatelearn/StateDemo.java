package com.hibernatelearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StateDemo {

    public static void main(String[] args) {
        // practical of hibernate object states :
        /*
         * 1.Transient state
         * 2.Persistent state
         * 3.Detached state
         * 4.Removed state
         */

        System.out.println("Example ...");

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
  
        //create object

        Student student = new Student();
        student.setId(14141);
        student.setName("Ramesh");
        student.setCity("Delhi");
        student.setCourse("Electrical");
        student.setCerti(new Cirtificate("java Hibernate course","2 months"));

        //student: transient
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(student);

        //student: persistent - session,database

        student.setName("john");

        // student:remove
        session.remove(student);
        
        transaction.commit();
        session.close();
        
        //student : detached 
        student.setName("sachin");
        System.out.println(student);

        sessionFactory.close();
    }

}
