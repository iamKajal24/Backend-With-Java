package com.map1;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Employee {

	@Id
	private int id;
	private String emp;

	@ManyToMany
	@JoinTable(name="emp_project",
	joinColumns = {@JoinColumn(name="eid")},
	inverseJoinColumns = {@JoinColumn(name="pid")})
	private List<Project> projects;

	public Employee() {
		super();
	}

	public Employee(int id, String emp, List<Project> projects) {
		super();
		this.id = id;
		this.emp = emp;
		this.projects = projects;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmp() {
		return emp;
	}

	public void setEmp(String emp) {
		this.emp = emp;
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", emp=" + emp + ", projects=" + projects + "]";
	}

}
