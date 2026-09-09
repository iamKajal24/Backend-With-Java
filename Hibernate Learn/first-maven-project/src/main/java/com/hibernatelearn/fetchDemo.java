package com.hibernatelearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class fetchDemo {

    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();


        //get-student, get()->nullprint karega
        Student student = (Student)session.get(Student.class, 2);
        System.out.println(student);


        //load()-> exception print karta hai
        // Address address = (Address)session.load(Address.class, 1);;
        // System.out.println(address);


        //getRefrence() -> exception print karega 
        // Student student =(Student)session.getReference(Student.class, 1);
        // System.out.println(student);

        // Student student =(Student)session.getReference(Student.class, 1);
        // System.out.println(student.getName()+ " , " + student.getCity());

        session.close();
        sessionFactory.close();
    


        
    }
}
