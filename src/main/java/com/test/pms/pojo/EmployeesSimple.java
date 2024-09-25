package com.test.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeesSimple {
    private Integer employeeId;
    private String name;
    private Integer age;
    private String employeePhoto;
    private LocalDateTime dateOnBoard;
}
