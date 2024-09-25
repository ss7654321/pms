package com.test.pms.controller;


import com.test.pms.pojo.Administrator;
import com.test.pms.pojo.Result;
import com.test.pms.service.AdministratorService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/Administrator")
public class AdministratorController {

//    private static final Logger log = LoggerFactory.getLogger(AdministratorController.class);
    @Autowired
    private AdministratorService administratorService;

    //查找
    @GetMapping
    public Result list(){
        List<Administrator> administrators = administratorService.list();
        log.info("list administrators: {}", administrators);
        return Result.success(administrators);
    }
    //删除
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){

        log.info("根据id删除部门:{}", id);

        administratorService.delete(id);
        return Result.success();
    }
    //新增
    @PostMapping
    public Result add(@RequestBody Administrator administrator) throws IOException {
        log.info("add administrator: {}", administrator);

        administratorService.add(administrator);
        return Result.success();
    }
    //根据id查找
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id){
        log.info("get administrator by id: {}", id);
        Administrator administrator = administratorService.getById(id);
        return Result.success(administrator);
    }

    //修改
    @PutMapping()
    public Result update(@RequestBody Administrator administrator){
        log.info("update administrator: {}", administrator);
        administratorService.update(administrator);
        return Result.success();
    }
}
