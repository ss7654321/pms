package com.test.pms.controller;

import com.test.pms.pojo.Result;
import com.test.pms.pojo.Supplier;
import com.test.pms.service.SupplierService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Slf4j
@RestController
@RequestMapping("/Supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;
    @GetMapping
    public Result list(){
        List<Supplier> suppliers= supplierService.list();
        log.info("查询全部成功");
        return Result.success(suppliers);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        supplierService.delete(id);
        log.info("删除Supplier的成员id为{}成功",id);
        return Result.success();
    }

    @PostMapping
    public Result save(@RequestBody Supplier supplier){
        log.info("add Supplier {}",supplier);
        supplierService.add(supplier);
        return Result.success();
    }
}
