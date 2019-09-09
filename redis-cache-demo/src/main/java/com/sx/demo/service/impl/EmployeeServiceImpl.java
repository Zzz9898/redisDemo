package com.sx.demo.service.impl;

import com.sx.demo.entity.Employee;
import com.sx.demo.mapper.EmployeeDao;
import com.sx.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;

    @Override
    @Cacheable(value = "emp",condition = "#a0 > 1")
    public Employee get(int id) {
        return employeeDao.getOne(id);
    }

    @Override
    @CachePut(value = "emp",key = "#result.id")
    public Employee put(Employee employee) {
        return employeeDao.save(employee);
    }

    @Override
    @CacheEvict(value = "emp",beforeInvocation = true)
    public void delete(int id) {
        System.out.println("delete" + id);
//        employeeDao.deleteById(id);
    }
}
