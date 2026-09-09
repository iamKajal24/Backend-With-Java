package com.hibernatelearn;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class QuesAnsMain {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();
        

        //creating Question
        // Questions questions = new Questions();
        // questions.setQuestion_id(1001);
        // questions.setQuestion("What is java ?");

        // //Answer Object
        // Answer answer = new Answer();
        // answer.setAnswer_id(2001);
        // answer.setAnswer("java is a object oriented programming language");
        // questions.setAnswer(answer);

        // Questions questions1 = new Questions();
        // questions1.setQuestion_id(1002);
        // questions1.setQuestion(" What is Collection framework?");

        // //Answer Object
        // Answer answer1 = new Answer();
        // answer1.setAnswer_id(2002);
        // answer1.setAnswer("api works with object in java");
        // questions1.setAnswer(answer1);

        Transaction transaction = session.beginTransaction();
        
        //save
        // session.save(questions);
        // session.save(questions1);
        // session.save(answer);
        // session.save(answer1);


        transaction.commit();

       
        //fetch data
        Questions questions2 = (Questions)session.get(Questions.class, 1001);
        System.out.println(questions2.getQuestion());
        
        // Answer answer2 = (Answer)session.get(Answer.class, 2001);
        // System.out.println(answer2.getAnswer());

        System.out.println(questions2.getAnswer().getAnswer());

        session.close();
        sessionFactory.close();
    }

}
