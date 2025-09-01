package com.kajal.hibernate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {

	@Id
	private int rollNo;
	private String sName;
	private int sAge;

	public Student(int rollNo, String sName, int sAge) {
		super();
		this.rollNo = rollNo;
		this.sName = sName;
		this.sAge = sAge;
	}

	public Student() {
		super();
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public int getsAge() {
		return sAge;
	}

	public void setsAge(int sAge) {
		this.sAge = sAge;
	}

	@Override
	public String toString() {
		return "Student [rollNo=" + rollNo + ", sName=" + sName + ", sAge=" + sAge + "]";
	}

}
