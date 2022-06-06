package com.pro.sky.collections.model;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int Limit = 10;

    public final List<Employee> employees = new ArrayList<>();

    public Employee add(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (employees.contains(employee)) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < Limit) {
            employees.add(employee);
            return employee;
        }
            throw new EmployeeStorageIsFullException();
    }
    public Employee remove(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employee);
        return employee;
    }

    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException();
        }
        for (Employee value : employees) {
            if (Objects.equals(value, employee)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>(employees.size());
        return new ArrayList<>(employees);
    }

}
