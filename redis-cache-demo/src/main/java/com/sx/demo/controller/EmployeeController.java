package com.sx.demo.controller;

import com.sx.demo.entity.Employee;
import com.sx.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/emp/get/{id}")
    public Employee get(@PathVariable int id){
        Employee employee = employeeService.get(id);
        return employee;
    }

    @GetMapping("/emp/put")
    public Employee post(Employee employee){
        employeeService.put(employee);
        return employee;
    }

    @GetMapping("/emp/delete/{id}")
    public String delete(@PathVariable int id){
        employeeService.delete(id);
        return "success";
    }
}
