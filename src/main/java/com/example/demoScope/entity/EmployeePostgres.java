package com.example.demoScope.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="EMPLOYEE")
public class EmployeePostgres {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="empId")
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

    public Date getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
}