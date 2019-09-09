package com.sx.demo.service;

import com.sx.demo.entity.Employee;

public interface EmployeeService {
    Employee get(int id);

    Employee put(Employee employee);

    void delete(int id);
}
