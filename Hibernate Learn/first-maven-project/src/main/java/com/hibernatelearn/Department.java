
package com.hibernatelearn;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Department {

    @Id
    private int department_id;

    private String department_name;

    // Ek Department ke multiple Employees ho sakte hain
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL)
    private List<Employee> employees;

    // Default constructor
    public Department() {
        super();
    }

    // Parameterized constructor
    public Department(int department_id, String department_name) {
        this.department_id = department_id;
        this.department_name = department_name;
    }

    public int getDepartment_id() {
        return department_id;
    }

    public void setDepartment_id(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartment_name() {
        return department_name;
    }

    public void setDepartment_name(String department_name) {
        this.department_name = department_name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Department [department_id=" + department_id
                + ", department_name=" + department_name
                + ", employees=" + employees + "]";
    }
}
