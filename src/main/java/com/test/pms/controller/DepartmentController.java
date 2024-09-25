package com.test.pms.controller;

import com.test.pms.pojo.Department;
import com.test.pms.pojo.Result;
import com.test.pms.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/Department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping
    public Result list(){
        List<Department> departments = departmentService.list();
        log.info("list departments: {}", departments);
        return Result.success(departments);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        departmentService.delete(id);
        log.info("delete department: {}", id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Department department){
        log.info("add department: {}", department);
        departmentService.add(department);
        return Result.success();
    }

}
