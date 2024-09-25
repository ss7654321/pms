package com.test.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderAll {
    private Order order = new Order();
    private List<OrderProduct> orderProducts = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
}
