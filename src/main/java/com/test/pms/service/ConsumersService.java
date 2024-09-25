package com.test.pms.service;

import com.test.pms.pojo.PageBean;
import com.test.pms.pojo.Users;

import java.time.LocalDate;
import java.util.List;

public interface ConsumersService {
    PageBean page(Integer page, Integer pageSize, String userName, LocalDate begin, LocalDate end);

    void delete(Integer id);

    void add(Users users);

    Users selectId(Integer id);
}
