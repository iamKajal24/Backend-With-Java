package com.kajal.hibernate;

import java.util.Arrays;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello World!");

        // Creating laptop objects
        Laptop l1 = new Laptop();
        l1.setLid(4);
        l1.setBrand("HP");
        l1.setModel("i5 processor");
        l1.setRam(16);

        Laptop l2 = new Laptop();
        l2.setLid(5);
        l2.setBrand("Dell");
        l2.setModel("Rog");
        l2.setRam(32);
        
        Laptop l3 = new Laptop();
        l3.setLid(6);
        l3.setBrand("HP");
        l3.setModel("X360");
        l3.setRam(32);
        
        

        // Creating alien
        Alien a1 = new Alien();
        a1.setAid(102);
        a1.setAname("Shalini Dixit");
        a1.setTech("SpringBoot");

        // Setting both sides of relationship
        l1.setAlien(a1);
        l2.setAlien(a1);
        a1.setLaptop(Arrays.asList(l1, l2,l3));

        // Configuration and session
        SessionFactory sFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(Alien.class)
                .addAnnotatedClass(Laptop.class)
                .buildSessionFactory();

        Session session = sFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // Persisting only alien (cascading saves laptop too)
        session.persist(a1);

        transaction.commit();

        // Fetching Alien
        Alien a2 = session.get(Alien.class, 101);

        session.close();
        sFactory.close();

        System.out.println(a2);
        System.out.println("Project completed.");
    }
}
