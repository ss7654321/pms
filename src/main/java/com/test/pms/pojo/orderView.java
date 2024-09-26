package com.test.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class orderView {
    private String username;
    private Double totalAmount;
    private String products;
    private LocalDate orderDate;
}
