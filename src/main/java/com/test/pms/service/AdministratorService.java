package com.test.pms.service;

import com.test.pms.pojo.Administrator;

import java.time.LocalDateTime;
import java.util.List;

public interface AdministratorService {
    List<Administrator> list();

    void delete(Integer id);

    void add(Administrator administrator);

    Administrator getById(Integer id);

    void update(Administrator administrator);
}
