package com.SpringBootTutorial;

public class Alien {

    private int aid;
    private String aname;

    // Getter and Setter for aid
    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    // Getter and Setter for aname
    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    // toString method
    @Override
    public String toString() {
        return "Alien [aid=" + aid + ", aname=" + aname + "]";
    }
}

