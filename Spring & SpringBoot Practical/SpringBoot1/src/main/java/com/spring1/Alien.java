package com.spring1;

import java.beans.ConstructorProperties;

import com.spring1.laptop;

public class Alien {

    private int age;

    private  laptop lap = new laptop();

   @ConstructorProperties({"age", "lap"})
    public Alien(int age, laptop lap) {
        System.out.println("parameterized constructor called");
        this.age = age;
        this.lap = lap;
    }

    public laptop getLap() {
        return lap;
    }

    public void setLap(laptop lap) {

        this.lap = lap;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        System.out.println("setter called");
        this.age = age;
    }

    public Alien(){
        System.out.println("Object created");
    }

    public void code(){
        System.out.println("Alien is coding");
        lap.compile();
    }

}
