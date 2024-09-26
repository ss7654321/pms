package com.test.pms.service.impl;

import com.test.pms.mapper.ProductMapper;
import com.test.pms.pojo.PageBean;
import com.test.pms.pojo.Product;
import com.test.pms.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    @Override
    public void delete(Integer id) {
        productMapper.deleteById(id);
    }

    @Override
    public void add(Product product) {
        product.setLastUpdateDate(LocalDate.now());
        productMapper.insert(product);
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String productName, String supplierName, LocalDate begin, LocalDate end) {
        //统计总记录数
        Integer count = productMapper.count();
        //获取分页数据
        Integer start = (page - 1) * pageSize;
        List<Product> lists = productMapper.list(start,pageSize,productName,supplierName,begin,end);
        //封装
        PageBean pageBean = new PageBean(count,lists);
        System.out.println("result: "+pageBean);
        return pageBean;
    }

    @Override
    public String select(Integer id) {
        return productMapper.selectDes(id);
    }

    @Override
    public void update(Product product) {
        product.setLastUpdateDate(LocalDate.now());
        productMapper.update(product);
    }
}
