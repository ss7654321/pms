package com.test.pms.service;

import com.test.pms.pojo.PageBean;
import com.test.pms.pojo.Product;

import java.time.LocalDate;

public interface ProductService {
    void delete(Integer id);

    void add(Product product);

    PageBean page(Integer page, Integer pageSize, String productName, String supplierName, LocalDate begin, LocalDate end);

    String select(Integer id);

    void update(Product product);
}
