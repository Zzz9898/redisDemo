package com.sx.demo.service.impl;

import com.sx.demo.entity.Department;
import com.sx.demo.mapper.DepartmentDao;
import com.sx.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.Cache;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.stereotype.Service;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Qualifier("deptCacheManager")
    @Autowired
    RedisCacheManager deptCacheManager;

    @Autowired
    private DepartmentDao departmentDao;

    @Override
    public Department get(int id) {
        Department department = departmentDao.getOne(id);
        Cache dep = deptCacheManager.getCache("dep");
        dep.put("dept:" + id ,department);
        return department;
    }
}
