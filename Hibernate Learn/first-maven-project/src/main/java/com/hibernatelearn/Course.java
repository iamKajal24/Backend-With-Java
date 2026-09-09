package com.hibernatelearn;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Course {

    @Id
    private int course_id;
    private String course_name;

    @ManyToMany(mappedBy = "course")
    private List<Students> student;

    public Course(int course_id, String course_name) {
        this.course_id = course_id;
        this.course_name = course_name;
    }

    public Course() {
        super();
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public List<Students> getStudent() {
        return student;
    }

    public void setStudent(List<Students> student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Course [course_id=" + course_id
                + ", course_name=" + course_name + "]";
    }

}
