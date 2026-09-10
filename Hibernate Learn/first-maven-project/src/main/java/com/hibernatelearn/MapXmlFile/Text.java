package com.hibernatelearn.MapXmlFile;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Text {

    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session s = sf.openSession();

        // Peron object

        PersonXmlEx p = new PersonXmlEx();
        p.setName("Sital");
        p.setAddress("laxmiNagar");

        PersonXmlEx p2 = new PersonXmlEx();
        p2.setName("Mouli");
        p2.setAddress("Rudrapryag");



        Transaction tx = s.beginTransaction();

        s.persist(p);
        s.persist(p2);
        System.out.println(p);

        tx.commit();
        s.close();
        sf.close();

    }

}
