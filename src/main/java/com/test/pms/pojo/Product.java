package com.test.pms.pojo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Product {
    /*product_id,
product_name,
product_price,
stock_quantity,
supplier_name,
last_update_date*/
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Integer stockQuantity;
    private String supplierName;
    private LocalDate lastUpdateDate;
    private String description;
}
