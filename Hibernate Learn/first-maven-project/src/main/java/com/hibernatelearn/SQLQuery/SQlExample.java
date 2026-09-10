package com.hibernatelearn.SQLQuery;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.NativeQuery;
import com.hibernatelearn.Student;

public class SQlExample {

    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
        Session session = sessionFactory.openSession();

        // String query = "select * from myStudents ";
        // NativeQuery nativeQuery =session.createNativeQuery(query, Student.class);
        // List<Student> list = nativeQuery.list();
        // for(Student st : list){
        // System.out.println(st.getId()+" : " + st.getName() + " : " + st.getCity());
        // }

        String query = "select city, count(id) from myStudents group by city ";

        NativeQuery<Object[]> nativeQuery = session.createNativeQuery(query);

        List<Object[]> list = nativeQuery.getResultList();

        for (Object[] row : list) {
            System.out.println(row[0] + " : " + row[1]);
        }

        session.close();
        sessionFactory.close();
    }

}
