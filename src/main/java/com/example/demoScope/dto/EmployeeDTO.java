package com.example.demoScope.dto;

import com.example.demoScope.entity.Employee;

import java.util.ArrayList;
import java.util.Date;
import java.util.stream.Stream;

public class EmployeeDTO extends ArrayList<Employee> {

    private int empId;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private Date dateOfJoining;

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

    public Date getDateOfJoining() { return dateOfJoining; }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }


}
