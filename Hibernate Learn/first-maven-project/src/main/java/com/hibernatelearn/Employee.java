
package com.hibernatelearn;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Employee {

    @Id
    private int employee_id;

    private String employee_name;

    // Many Employees ek Department se belong kar sakte hain
    @ManyToOne
    private Department department;

    // Default constructor
    public Employee() {
        super();
    }

    // Parameterized constructor
    public Employee(int employee_id, String employee_name) {
        this.employee_id = employee_id;
        this.employee_name = employee_name;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getEmployee_name() {
        return employee_name;
    }

    public void setEmployee_name(String employee_name) {
        this.employee_name = employee_name;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee [employee_id=" + employee_id
                + ", employee_name=" + employee_name + "]";
    }
}

