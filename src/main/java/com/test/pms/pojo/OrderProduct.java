package com.test.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class OrderProduct {
    private Integer orderProductId;
    private Integer orderId;
    private Integer productId;
    private Integer quantity;
}
