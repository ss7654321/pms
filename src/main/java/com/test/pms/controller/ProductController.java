package com.test.pms.controller;

import com.test.pms.mapper.ProductMapper;
import com.test.pms.pojo.PageBean;
import com.test.pms.pojo.Product;
import com.test.pms.pojo.Result;
import com.test.pms.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("/Product")
public class ProductController {
    @Autowired
    private ProductService productService;
    //@RequestMapping(value = "/Product",method = RequestMethod.GET)
    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer pageSize,
                       String productName,
                       String supplierName,
                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin, @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("page {} pageSize {}", page, pageSize);
        PageBean pageBean = productService.page(page,pageSize,productName,supplierName,begin,end);
        return Result.success(pageBean);
    }
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id){
        log.info("findById {}", id);
        String des = new String();
        des = productService.select(id);
        return Result.success(des);
    }

    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        productService.delete(id);
        log.info("Product delete {}",id);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody Product product){
        log.info("Product add {}",product);
        productService.add(product);
        return Result.success();
    }
}
