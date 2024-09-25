package com.test.pms.pojo;

import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Supplier {
    private Integer supplierId;
    private String supplierName;
    private String contactInfo;
    private LocalDate lastUpdateDate;
}
