package com.hibernatelearn.CriteriaExample;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.cfg.Configuration;

import com.hibernatelearn.Student;

import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;

public class CriterialApiEx {

    public static void main(String[] args) {

        Session session = new Configuration().configure().buildSessionFactory().openSession();

        CriteriaBuilder cb =session.getCriteriaBuilder();

        CriteriaQuery<Student> cq = cb.createQuery(Student.class);

        Root<Student> root = cq.from(Student.class);

        //for all data
        //cq.select(root);

        //for restriction data
    
        cq.select(root).where(cb.equal(root.get("city"),"Delhi"));

        

        List<Student> list = session.createQuery(cq).getResultList();

        for (Student st : list) {
            System.out.println(st);
        }

        session.close();

    }

}
