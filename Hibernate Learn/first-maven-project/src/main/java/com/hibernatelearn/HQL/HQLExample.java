package com.hibernatelearn.HQL;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.hibernatelearn.Student;

public class HQLExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();

        Session session = sessionFactory.openSession();

        // HQL Syntax :
        // String query = "from Student where city='Haridwar'";
        String query = "from Student where city=:x";
        Query q = session.createQuery(query);

        q.setParameter("x", "Haridwar");

        // single-unique
        // multiple-list
        List<Student> list = q.list();

        for (Student student : list) {
            System.out.println(student.getName() + " , " + student.getCity());
        }

        System.out.println("*********************************");

        Transaction transaction = session.beginTransaction();

        // delete
        // Query q2 =session.createQuery("delete from Student where id =:i");
        // q2.setParameter("i", 18);
        // int r =q2.executeUpdate();
        // System.out.println("Deleted...");
        // System.out.println(r);

        // update

        Query q3 =session.createQuery("update Student set city=:c where name=:n");
        q3.setParameter("c", "Delhi");
        q3.setParameter("n", "kajal");
        int r= q3.executeUpdate();
        System.out.println(r+" Object Updated ...");

        transaction.commit();
        session.close();
        sessionFactory.close();

    }

}
