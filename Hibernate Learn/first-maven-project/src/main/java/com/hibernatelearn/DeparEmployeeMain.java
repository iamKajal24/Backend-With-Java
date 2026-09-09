package com.hibernatelearn;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class DeparEmployeeMain {

    public static void main(String[] args) {

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory sessionFactory = cfg.buildSessionFactory();
        Session session = sessionFactory.openSession();

        // creating department object

        // Department department = new Department();
        // department.setDepartment_id(102);
        // department.setDepartment_name("Networking");

        // // Employee object
        // Employee employee = new Employee();
        // employee.setEmployee_id(204);
        // employee.setEmployee_name("Shubham chauhan");

        // Employee employee2 = new Employee();
        // employee2.setEmployee_id(205);
        // employee2.setEmployee_name("Mohit Sharma");

        // employee ko department ke saath connect karna hai
        // employee.setDepartment(department);
        // employee2.setDepartment(department);

        // employee ki list bnana hai
        // List<Employee> employeess = new ArrayList<>();
        // employeess.add(employee);
        // employeess.add(employee2);

        // list ko department mei set karna hai
        // department.setEmployees(employeess);

        // Transaction transaction = session.beginTransaction();

        // session.save(department);
        // session.save(employee);
        // session.save(employee2);

        // transaction.commit();

        // data fetch
        // Department department =(Department)session.get(Department.class,101 );
        // System.out.println(department.getDepartment_name());
        // System.out.println(department.getEmployees());

        Department department = session.get(Department.class, 101); // Check karna ki department mila ya nahi if
            if(department!=null){
                System.out.println(department.getDepartment_id());
                System.out.println(department.getDepartment_name());
                System.out.println(department.getEmployees());
            }
            else{
                System.out.println("Department nhi mila");
            }   
            
        Employee employee =(Employee)session.get(Employee.class, 201);
        System.out.println(employee.getEmployee_name());
        System.out.println(employee.getDepartment());
        System.out.println(employee.getDepartment());

        session.close();
        sessionFactory.close();
    }

}
