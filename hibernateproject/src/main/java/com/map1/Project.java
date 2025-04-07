package com.map1;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Project {

	@Id
	private int project_id;
	@Column(name = "project_name")
	private String projectName;

	@ManyToMany(mappedBy = "projects")
	private List<Employee> emps;

	public Project() {
		super();
	}

	public Project(int project_id, String projectName, List<Employee> emps) {
		super();
		this.project_id = project_id;
		this.projectName = projectName;
		this.emps = emps;
	}

	public int getProject_id() {
		return project_id;
	}

	public void setProject_id(int project_id) {
		this.project_id = project_id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmps() {
		return emps;
	}

	public void setEmps(List<Employee> emps) {
		this.emps = emps;
	}

	@Override
	public String toString() {
		return "Project [project_id=" + project_id + ", projectName=" + projectName + ", emps=" + emps + "]";
	}

}
