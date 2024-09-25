package com.test.pms.service.impl;

import com.test.pms.mapper.AdministratorMapper;
import com.test.pms.pojo.Administrator;
import com.test.pms.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;

    @Override
    public List<Administrator> list() {
        return administratorMapper.list();
    }

    @Override
    public void delete(Integer id) {
        administratorMapper.deleteById(id);
    }

    @Override
    public void add(Administrator administrator) {
//        administrator.setCreateTime(LocalDateTime.now());
        //administrator.setUpdateTime(LocalDateTime.now());
        administrator.setLastUpdateDate(LocalDateTime.now());
        administratorMapper.insert(administrator);
    }

    @Override
    public Administrator getById(Integer id) {
        return administratorMapper.selectById(id);
    }

    @Override
    public void update(Administrator administrator) {
        administrator.setLastUpdateDate(LocalDateTime.now());
        administratorMapper.update(administrator);
    }
}
