package com.test.pms.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsersSimple {
    private Integer userId;
    private String userName;
    private String userPhoto;
    private String phone;
    private LocalDateTime registrationDate;
}
