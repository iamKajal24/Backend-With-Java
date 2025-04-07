package com.hibernatelearn;

import javax.persistence.*;

import org.hibernate.annotations.Cache;


@Entity
@Table(name = "student")
@Cacheable

public class Student {

    @Id
    private int id;

    @Column(name = "student_name", length = 50, nullable = false)
    private String name;

    @Column(name = "student_city", length = 50, nullable = false)
    private String city;

    @Embedded
    private Certificate certi;

    public Student() {
        super();
    }

    public Student(int id, String name, String city, Certificate certi) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;
        this.certi = certi;
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

    public Certificate getCerti() {
        return certi;
    }

    public void setCerti(Certificate certi) {
        this.certi = certi;
    }

    @Override
    public String toString() {
        return "Student [id=" + id + ", name=" + name + ", city=" + city + ", certi=" + certi + "]";
    }
}
