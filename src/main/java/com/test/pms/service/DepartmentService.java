package com.test.pms.service;

import com.test.pms.pojo.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> list();

    void delete(Integer id);

    void add(Department department);
}
