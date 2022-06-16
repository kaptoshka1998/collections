package com.pro.sky.collections.model;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeService {

    private static final int Limit = 10;

    public final Map<String, Employee> employees = new HashMap<>();

    private String getKey(Employee employee) {
        return employee.getFirstName() + " " + employee.getSecondName();
    }

    public Employee add(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        if (employees.containsKey(getKey(employee))) {
            throw new EmployeeAlreadyAddedException();
        }
        if (employees.size() < Limit) {
            employees.put(getKey(employee), employee);
            return employee;
        }
            throw new EmployeeStorageIsFullException();
    }
    public Employee remove(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        String employeeKey = getKey(employee);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(employeeKey);
        return employee;
    }

    public Employee find(String firstName, String secondName) {
        Employee employee = new Employee(firstName, secondName);
        String employeeKey = getKey(employee);
        if (!employees.containsKey(employeeKey)) {
            throw new EmployeeNotFoundException();
        }
        throw new EmployeeNotFoundException();
    }

    public List<Employee> getAll() {
        List<Employee> result = new ArrayList<>(employees.size());
        return new ArrayList<>(employees.values());
    }

}
