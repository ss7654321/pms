package com.test.pms.controller;

import com.test.pms.pojo.*;
import com.test.pms.service.OrderService;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/Order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @GetMapping
    public Result page(@RequestParam(defaultValue = "1") Integer page
    , @RequestParam(defaultValue = "10") Integer pageSize
    , String userName
    , String productName
    , @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,@DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("page {} pageSize {}", page, pageSize);
        PageBean pageBean = orderService.page(page,pageSize,userName,productName,begin,end);
        return Result.success(pageBean);
    }
    @GetMapping("/{id}")
    public Result select(@PathVariable Integer id){
        log.info("id {}",id);

        OrderAll orderAll = orderService.select(id);
        return Result.success(orderAll);
    }


    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        orderService.delete(id);
        log.info("Order delete: {}", id);
        return Result.success();
    }

    @PutMapping
    public Result update(@RequestBody OrderAll orderAll){
        orderService.update(orderAll);
        log.info("Order update: {}", orderAll);
        return Result.success();
    }

    @PostMapping
    public Result add(@RequestBody OrderAll orderAll){
        log.info("Order add: {}", orderAll);
        orderService.add(orderAll);
        return Result.success();
    }
}
