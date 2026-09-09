package com.hibernatelearn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class StuCourseMain {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // creating object
        // Students students = new Students();
        // students.setStudent_id(1001);
        // students.setStudent_name("kajal");

        // Students students1 = new Students();
        // students1.setStudent_id(1002);
        // students1.setStudent_name("Shubham chauhan");

        // Students students2 = new Students();
        // students2.setStudent_id(1003);
        // students2.setStudent_name("Khushi Upadhya");

        // // course object
        // Course course = new Course();
        // course.setCourse_id(2001);
        // course.setCourse_name("Java");

        // Course course1 = new Course();
        // course1.setCourse_id(2002);
        // course1.setCourse_name("Python");

        // Course course2 = new Course();
        // course2.setCourse_id(2003);
        // course2.setCourse_name("SQL");

        // // student 1 ke courses
        // List<Course> courses = new ArrayList<>();
        // courses.add(course);
        // courses.add(course1);

        // students.setCourse(courses);

        // // student 2 ke liye
        // List<Course> courses2 = new ArrayList<>();
        // courses2.add(course1);
        // courses2.add(course);

        // students1.setCourse(courses2);

        // // students 3 ke liye
        // List<Course> courses3 = new ArrayList<>();
        // courses3.add(course2);
        // courses3.add(course1);
        // students2.setCourse(courses3);

        // Transaction transaction = session.beginTransaction();

        // session.persist(students);
        // session.persist(students1);
        // session.persist(students2);
        // session.persist(course);
        // session.persist(course1);
        // session.persist(course2);

        // transaction.commit();

        // data fetch

        // Students studentss = (Students) session.get(Students.class, 1001);
        // System.out.println(studentss.getStudent_name());
        // System.out.println(studentss.getCourse());

        // Course courseFetch = (Course)session.get(Course.class, 2001);
        // System.out.println(courseFetch.getCourse_name());
        // System.out.println(courseFetch.getStudent());

        Students studentss = session.get(Students.class, 1001);

        System.out.println("Student Name: " + studentss.getStudent_name());

        for (Course course : studentss.getCourse()) {
            System.out.println("Course ID: " + course.getCourse_id());
            System.out.println("Course Name: " + course.getCourse_name());
        }

        session.close();
        sessionFactory.close();

    }

}
