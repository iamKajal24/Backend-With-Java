package com.hibernatelearn;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("project started!...");

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        System.out.println(sessionFactory);

        // student object

        Student student = new Student();
        student.setId(103);
        student.setCity("Lunknow");
        student.setName("Mohit Sharma");
        student.setCourse("Electrical");
        System.out.println(student);

        Address address = new Address();
        address.setStreet("street4");
        address.setCity("Lucknow");
        address.setOpen(true);
        address.setAddedDate(new Date(0));
        address.setX(12345.67);

        // reading image
        String path = "D:\\Hibernate Learn\\first-maven-project\\src\\main\\image\\Screenshot (26).jpg";

        try (FileInputStream fis = new FileInputStream(path)) {

            byte[] data = fis.readAllBytes();

            System.out.println("Image size = " + data.length + " bytes");

            address.setImage(data);
        }

        System.out.println(address);
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        // data ko save karne ke liye
        session.save(student);
        session.save(address);

        // new record ko save karne liye
        // session.persist(student);
        // session.persist(address);
        transaction.commit();
        ;
        session.close();

        sessionFactory.close();
        System.out.println(sessionFactory.isClosed());
    }
}
