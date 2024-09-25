package com.test.pms.pojo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Integer orderId;
    private LocalDate orderDate;
    private Double totalAmount;
    private String billingAddress;
    private Integer userId;
    private LocalDate lastUpdateDate;
}