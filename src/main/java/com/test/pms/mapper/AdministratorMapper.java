package com.test.pms.mapper;

import com.test.pms.pojo.Administrator;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface AdministratorMapper {
    @Select("select * from enss.administrators")
    List<Administrator> list();
    @Delete("delete from enss.administrators where administrators_id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into enss.administrators VALUES (#{administratorsId},#{gender},#{age},#{administratorAccount},#{administratorPassword},#{lastUpdateDate})")
    void insert(Administrator administrator);

    //回显
    @Select("select * from enss.administrators where administrators_id = #{id}")
    Administrator selectById(Integer id);

    void update(Administrator administrator);
}
