package com.test.pms.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Employees {
    private Integer employeeId;
    private String name;
    private Integer departmentId;
    private Integer age;
    private String employeePhoto;
    private String professionalTitle;
    private LocalDateTime dateOnBoard;
    private LocalDateTime lastUpdateDate;
}
