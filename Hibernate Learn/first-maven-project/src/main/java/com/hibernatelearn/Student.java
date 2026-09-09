package com.hibernatelearn;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "myStudents")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String city;
    private String course;

    private  Cirtificate certi;

    public Cirtificate getCerti() {
        return certi;
    }

    public void setCerti(Cirtificate certi) {
        this.certi = certi;
    }

    public Student() {
        super();
    }

    public Student(int id, String name, String city, String course) {
        this.id = id;
        this.name = name;
        this.city = city;
        this.course = course;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", city=" + city + ", course=" + course + ", certi=" + certi
                + "]";
    }

   
}
