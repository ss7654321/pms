package com.test.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Administrator {
    private Integer administratorsId;
    private Integer gender;
    private Integer age;
    private String administratorAccount;
    private String administratorPassword;
    private LocalDateTime lastUpdateDate;
}
