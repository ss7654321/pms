package com.test.pms.controller;

import com.test.pms.pojo.Employees;
import com.test.pms.pojo.PageBean;
import com.test.pms.pojo.Result;
import com.test.pms.service.EmployeesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
@Slf4j
@RestController
@RequestMapping("/Employees")
public class EmployeesController {

    @Autowired
    private EmployeesService employeesService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10") Integer pageSize
            , String name
            , Integer age
            , String professionalTitle
            , @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("page {} pageSize {}", page, pageSize);
        PageBean pageBean = employeesService.page(page,pageSize,name,age,professionalTitle,begin,end);
        return Result.success(pageBean);
    }
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("findById {}", id);
        Employees employee = employeesService.select(id);
        return Result.success(employee);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        employeesService.delete(id);
        log.info("employees delete: {}", id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Employees employees){
        log.info("employees add: {}", employees);
        employeesService.add(employees);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Employees employees){
        log.info("employees update: {}", employees);
        employeesService.update(employees);
        return Result.success();
    }
}
