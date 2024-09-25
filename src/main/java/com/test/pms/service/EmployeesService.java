package com.test.pms.service;

import com.test.pms.pojo.Employees;
import com.test.pms.pojo.PageBean;

import java.time.LocalDate;
import java.util.List;

public interface EmployeesService {

    void delete(Integer id);

    void add(Employees employees);

    PageBean page(Integer page, Integer pageSize, String name, Integer age, String professionalTitle, LocalDate begin, LocalDate end);

    Employees select(Integer id);
}
