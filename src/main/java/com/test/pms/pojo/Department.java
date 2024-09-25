package com.test.pms.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Department {
    private Integer departmentId;
    private String departmentName;
    private LocalDateTime creationDate;
    private LocalDateTime lastUpdateDate;
}
