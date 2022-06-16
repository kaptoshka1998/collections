package com.pro.sky.collections.model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public Employee add(@RequestParam("firstName") String firstName,
                        @RequestParam("secondName") String secondName) {
        return employeeService.add(firstName, secondName);
    }
    @GetMapping("/remove")
    public Employee remove(@RequestParam("firstName") String firstName,
                        @RequestParam("secondName") String secondName) {
        return employeeService.add(firstName, secondName);
    }
    @GetMapping("/find")
    public Employee find(@RequestParam("firstName") String firstName,
                        @RequestParam("secondName") String secondName) {
        return employeeService.add(firstName, secondName);
    }
    @GetMapping("/")
    public List<Employee> getAll() {
        return employeeService.getAll();
    }
}

