package com.test.pms.service.impl;

import com.test.pms.mapper.OrderMapper;
import com.test.pms.mapper.ProductMapper;
import com.test.pms.pojo.*;
import com.test.pms.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;

@Service
public class OrderServiceImpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private ProductMapper productMapper;

    @Override
    public void delete(Integer id) {
        orderMapper.deleteById();
    }

    @Override
    public void add(OrderAll orderAll) {
        orderAll.getOrder().setOrderDate(LocalDate.now());
        orderAll.getOrder().setLastUpdateDate(LocalDate.now());
        Double sum = 0.0;
        orderAll.getOrder().setOrderId(orderMapper.max()+1);
        for (OrderProduct element : orderAll.getOrderProducts()) {
            sum += productMapper.findPrice(element.getProductId()) * element.getQuantity();
            orderMapper.insert(element);
        }
        orderAll.getOrder().setTotalAmount(sum);
        orderMapper.insertOrder(orderAll.getOrder());
    }

    @Override
    public PageBean page(Integer page, Integer pageSize, String userName, String productName, LocalDate begin, LocalDate end) {
        //获取总记录数
        Integer count = orderMapper.count();
        //获取分页数据列表
        Integer start = (page - 1) * pageSize;
        List<orderView> lists = orderMapper.list(start,pageSize,userName,productName,begin,end);
        //封装PageBean对象
        PageBean pageBean = new PageBean(count,lists);
        System.out.println("结果"+pageBean);
        return pageBean;
    }

    @Override
    public OrderAll select(Integer id) {
        OrderAll orderAll = new OrderAll();
        orderAll.setOrder(orderMapper.selector(id));
        orderAll.setOrderProducts(orderMapper.selectOp(id));
        List<Product> products = new ArrayList<>();
        for(OrderProduct orderProduct : orderAll.getOrderProducts()){
            products.add(productMapper.selectById(orderProduct.getProductId()));
        }
        orderAll.setProducts(products);
        return orderAll;
    }

    @Override
    public void update(OrderAll orderAll) {
        orderAll.getOrder().setLastUpdateDate(LocalDate.now());
        Double sum = 0.0;
        for (OrderProduct element : orderAll.getOrderProducts()) {
            orderMapper.updateOp(element.getProductId(),element.getQuantity());
            sum += productMapper.findPrice(element.getProductId())
                    *
                    orderMapper.selectOpByOpId(element.getOrderProductId()).getQuantity();
        }
        orderAll.getOrder().setTotalAmount(sum);
        orderMapper.updateOr(orderAll.getOrder());
    }
}
