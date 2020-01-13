package com.example.demoScope.entity;

import javax.persistence.Entity;
import java.util.Date;

@Entity
public class Employee {

    private int empId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private long Experience;

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setExperience(String Experience) {
        this.Experience = Experience;
    }

    public int getEmpId() {

        return empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public long getExperience() {
        return Experience;
    }

    public void setfirstName(String firstname) {
    }

    public void setlastName(String lastname) {
    }

    public void setDateOfBirth(String value) {
    }
}
