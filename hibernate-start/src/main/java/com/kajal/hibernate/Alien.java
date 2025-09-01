package com.kajal.hibernate;

import java.util.List;
import jakarta.persistence.*;

@Entity
public class Alien {

    @Id
    private int aid;

    private String aname;
    private String tech;

    @OneToMany(mappedBy = "alien", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Laptop> laptop;

    public int getAid() {
        return aid;
    }

    public void setAid(int aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getTech() {
        return tech;
    }

    public void setTech(String tech) {
        this.tech = tech;
    }

    public List<Laptop> getLaptop() {
        return laptop;
    }

    public void setLaptop(List<Laptop> laptop) {
        this.laptop = laptop;
    }

    @Override
    public String toString() {
        return "Alien [aid=" + aid + ", aname=" + aname + ", tech=" + tech + ", laptop=" + laptop + "]";
    }
}
