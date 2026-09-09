package com.hibernatelearn;

import jakarta.persistence.Embeddable;

@Embeddable 
public class Cirtificate {

    private String course_name;
    private String duration;

    public Cirtificate(String course_name, String duration) {
        this.course_name = course_name;
        this.duration = duration;
    }

    public Cirtificate() {
        super();
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Cirtificate [course_name=" + course_name + ", duration=" + duration + "]";
    }

}
