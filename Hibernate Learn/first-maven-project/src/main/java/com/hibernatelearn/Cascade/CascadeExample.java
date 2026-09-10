package com.hibernatelearn.Cascade;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.hibernatelearn.Answer;
import com.hibernatelearn.Questions;

public class CascadeExample {

    public static void main(String[] args) {
        SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        

        Questions q1 = new Questions();
        q1.setQuestion("what is cascading ?");
        q1.setQuestion_id(67);


        Answer a1 = new Answer();
        a1.setAnswer_id(34);
        a1.setAnswer("In hibernate it it important concept");

        Answer a2 = new Answer(45,"Second answer");
        
        Answer a3 = new Answer(98,"Third answer");


        List<Answer> l1 = new ArrayList<>();
        l1.add(a1);
        l1.add(a2);
        l1.add(a3);

         q1.setAnswer(l1);
        
         Transaction tx = session.beginTransaction();
         session.save(q1);
         session.save(a1);
         session.save(a2);
         session.save(a3);

        tx.commit();
        session.close();
        sessionFactory.close();
    }
    
}
