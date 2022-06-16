package com.pro.sky.collections.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Objects;


public class Employee {
    @JsonProperty("firstName")
    private String firstName;
    @JsonProperty("lastName")
    private String secondName;


    public Employee(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;

    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getSecondName() {
        return this.secondName;
    }


    public String toString() {
        return "ФИО  " + this.firstName + " " + this.secondName ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(secondName, employee.secondName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, secondName);
    }
}
