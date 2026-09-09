package com.hibernatelearn;

import java.sql.Date;
import java.util.Arrays;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.persistence.Transient;

@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "address_id")
    private int addressId;

    @Column(length = 100, name = "STREET")
    private String street;

    @Column(length = 100, name = "CITY")
    private String city;

    @Column(name = "is_Open")
    private boolean isOpen;

    @Transient
    private double x;

    @Temporal(TemporalType.DATE)
    private Date addedDate;

    @Lob
    @Column(columnDefinition = "LONGBLOB")
    private byte[] image;

    public Address(int addressId, String street, String city, boolean isOpen, double x, Date addedDate, byte[] image) {
        this.addressId = addressId;
        this.street = street;
        this.city = city;
        this.isOpen = isOpen;
        this.x = x;
        this.addedDate = addedDate;
        this.image = image;
    }

    public Address() {
        super();
    }

    public int getAddressId() {
        return addressId;
    }

    public String getStreet() {
        return street;
    }

    public String getCity() {
        return city;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public double getX() {
        return x;
    }

    public Date getAddedDate() {
        return addedDate;
    }

    public byte[] getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Address [addressId=" + addressId + ", street=" + street + ", city=" + city + ", isOpen=" + isOpen
                + ", x=" + x + ", addedDate=" + addedDate + ", image=" + Arrays.toString(image) + "]";
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOpen(boolean isOpen) {
        this.isOpen = isOpen;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setAddedDate(Date addedDate) {
        this.addedDate = addedDate;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

}
