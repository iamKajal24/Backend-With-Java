package com.hibernatelearn.Pagination;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hibernatelearn.Student;

import org.hibernate.query.Query;

public class HQLPagination{
    public static void main(String[] args) {
        
        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        Query query =session.createQuery("from Student",Student.class);  

        //implementing pegination using hibernate
        query.setFirstResult(7);
        query.setMaxResults(10);
        
        List<Student> list = query.list();

        for(Student student:list){
            System.out.println(student.getId()+" : "+student.getName()+" : " + student.getCity()+" : " + student.getCourse());
        }


        session.close();
        sessionFactory.close();
    }
}