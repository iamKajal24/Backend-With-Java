package com.hibernatelearn;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("Project started...");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();

        // Creating Student object
        Student stu = new Student();
        stu.setId(102);
        stu.setName("KAJAL");
        stu.setCity("HARIDWAR");
        System.out.println(stu);

        // Creating Address object
        Address ad = new Address();
        ad.setStreet("Street2");
        ad.setCity("HARIDWAR");
        ad.setOpen(true);
        ad.setAddedDate(new Date()); // Use Date for compatibility
        ad.setX(11343.77);
        
        //reading image
        FileInputStream fis = new FileInputStream("src/main/java/rose.jpeg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        System.out.println(ad);

        // Hibernate Session
        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(stu);
        session.save(ad);
        tx.commit();
        session.close();

        System.out.println("Successfully added");
        System.out.println("Factory closed: " + factory.isClosed());
    }
}
