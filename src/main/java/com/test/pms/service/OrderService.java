package com.test.pms.service;

import com.test.pms.pojo.OrderAll;
import com.test.pms.pojo.PageBean;

import java.time.LocalDate;
import java.util.Map;

public interface OrderService {
    void delete(Integer id);

    void add(OrderAll orderAll);

    PageBean page(Integer page, Integer pageSize, String userName, String productName, LocalDate begin,LocalDate end);

    OrderAll select(Integer id);

    void update(OrderAll orderAll);
}
