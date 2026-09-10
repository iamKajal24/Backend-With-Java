package com.hibernatelearn.MapXmlFile;

public class PersonXmlEx {

    private int id;
    private String name;
    private String address;

    public PersonXmlEx(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public PersonXmlEx() {
        super();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "PersonXmlEx [id=" + id + ", name=" + name + ", address=" + address + "]";
    }

}
