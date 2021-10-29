package com.codegym.demo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "division")
public class Division {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int divisionId;
    private String divisionName;

    @OneToMany(mappedBy = "division")
    private List<Employee> employeeList;

    public Division() {
    }

    public Division(String name, List<Employee> employeeList) {
        this.divisionName = name;
        this.employeeList = employeeList;
    }

    public Division(int id, String name, List<Employee> employeeList) {
        this.divisionId = id;
        this.divisionName = name;
        this.employeeList = employeeList;
    }

    public int getDivisionId() {
        return divisionId;
    }

    public void setDivisionId(int id) {
        this.divisionId = id;
    }

    public String getDivisionName() {
        return divisionName;
    }

    public void setDivisionName(String name) {
        this.divisionName = name;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
