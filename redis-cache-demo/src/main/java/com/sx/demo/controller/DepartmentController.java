package com.sx.demo.controller;

import com.sx.demo.entity.Department;
import com.sx.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/dep/get/{id}")
    public Department get(@PathVariable int id){
        Department department = departmentService.get(id);
        return department;
    }
}
