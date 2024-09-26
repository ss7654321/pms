package com.test.pms.service.impl;

import com.test.pms.mapper.DepartmentMapper;
import com.test.pms.pojo.Department;
import com.test.pms.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentMapper departmentMapper;

    @Override
    public List<Department> list() {
        return departmentMapper.list();
    }

    @Override
    public void delete(Integer id) {
        departmentMapper.deleteById(id);
    }

    @Override
    public void add(Department department) {
        department.setCreationDate(LocalDateTime.now());
        department.setLastUpdateDate(LocalDateTime.now());
        departmentMapper.insert(department);
    }

    @Override
    public void update(Department department) {
        department.setLastUpdateDate(LocalDateTime.now());
        departmentMapper.update(department);
    }
}
