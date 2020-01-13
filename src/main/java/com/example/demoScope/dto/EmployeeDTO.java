package com.example.demoScope.dto;

import java.util.Date;

public class EmployeeDTO {

    private int empId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private String experience;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getExperience(){ return experience;}

    public void setExperience(String experience) { this.experience = experience; }

}
