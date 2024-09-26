package com.test.pms.controller;

import com.test.pms.pojo.PageBean;
import com.test.pms.pojo.Users;
import com.test.pms.pojo.Result;
import com.test.pms.service.ConsumersService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/Consumers")
public class ConsumersController {
    @Autowired
    private ConsumersService consumerService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page
            , @RequestParam(defaultValue = "10") Integer pageSize
            , String userName
            , @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        PageBean pageBean = consumerService.page(page,pageSize,userName,begin,end);
        log.info("list consumers: {}", pageBean);
        return Result.success(pageBean);
    }
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        Users user = consumerService.selectId(id);
        log.info("user: {}", user);
        return Result.success(user);
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        consumerService.delete(id);
        log.info("delete consumer: {}", id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Users users){
        log.info("add consumer: {}", users);
        consumerService.add(users);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody Users users){
        log.info("update consumer: {}", users);
        consumerService.update(users);
        return Result.success();
    }
}
