package com.hibernatelearn;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Students {

    @Id
    private int student_id;
    private String student_name;

    @ManyToMany(cascade = CascadeType.ALL)
    private List<Course> course;

    public Students(int student_id, String student_name) {
        this.student_id = student_id;
        this.student_name = student_name;
    }

    public Students() {
        super();
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public List<Course> getCourse() {
        return course;
    }

    public void setCourse(List<Course> course) {
        this.course = course;
    }

    @Override
    public String toString() {
        return "Students [student_id=" + student_id
                + ", student_name=" + student_name + "]";
    }

}
