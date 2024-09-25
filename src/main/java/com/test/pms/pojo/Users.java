package com.test.pms.pojo;

import lombok.*;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Users {
    private Integer userId;
    private String userName;
    private String password;
    private String userPhoto;
    private String phone;
    private String userAccount;
    private String userAddress;
    private LocalDateTime lastUpdateDate;
    private LocalDateTime registrationDate;
}
