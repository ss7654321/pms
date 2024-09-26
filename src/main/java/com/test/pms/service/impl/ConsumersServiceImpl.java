package com.test.pms.service.impl;

import com.test.pms.mapper.ConsumersMapper;
import com.test.pms.pojo.PageBean;
import com.test.pms.pojo.Users;
import com.test.pms.pojo.UsersSimple;
import com.test.pms.service.ConsumersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Service
public class ConsumersServiceImpl implements ConsumersService {
    @Autowired
    private ConsumersMapper consumersMapper;

    @Override
    public PageBean page(Integer page, Integer pageSize, String userName, LocalDate begin, LocalDate end) {
        //统计总数
        Integer count = consumersMapper.count();
        //获取分页数据
        Integer start = (page - 1) * pageSize;
        List<UsersSimple> lists = consumersMapper.list(start,pageSize,userName,begin,end);
        //封装
        return new PageBean(count,lists);
    }

    @Override
    public void delete(Integer id) {
        consumersMapper.deleteById(id);
    }

    @Override
    public void add(Users users) {
        users.setRegistrationDate(LocalDateTime.now());
        users.setLastUpdateDate(LocalDateTime.now());
        consumersMapper.insert(users);
    }

    @Override
    public Users selectId(Integer id) {
        return consumersMapper.select(id);
    }

    @Override
    public void update(Users users) {
        users.setLastUpdateDate(LocalDateTime.now());
        consumersMapper.update(users);
    }
}
