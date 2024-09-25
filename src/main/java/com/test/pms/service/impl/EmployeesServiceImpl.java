package com.test.pms.service.impl;

import com.test.pms.controller.UploadController;
import com.test.pms.mapper.EmployeesMapper;
import com.test.pms.pojo.Employees;
import com.test.pms.pojo.EmployeesSimple;
import com.test.pms.pojo.PageBean;
import com.test.pms.service.EmployeesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class EmployeesServiceImpl implements EmployeesService {
    @Autowired
    private EmployeesMapper employeesMapper;

    @Autowired
    private UploadController uploadController;

    @Override
    public void delete(Integer id) {
        employeesMapper.deleteById(id);
    }

    @Override
    public void add(Employees employees) {
        employees.setDateOnBoard(LocalDateTime.now());
        employees.setLastUpdateDate(LocalDateTime.now());

        employeesMapper.insert(employees);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String name, Integer age, String professionalTitle, LocalDate begin, LocalDate end) {
        Integer count = employeesMapper.count();
        Integer start = (page - 1) * pageSize;
        List<EmployeesSimple> lists = employeesMapper.list(page,pageSize,name,age,professionalTitle,begin,end);

        return new PageBean(count,lists);
    }

    @Override
    public Employees select(Integer id) {
        return employeesMapper.select(id);
    }
}
