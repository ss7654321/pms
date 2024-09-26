package com.test.pms.mapper;

import com.test.pms.pojo.Administrator;
import com.test.pms.pojo.Users;
import com.test.pms.pojo.UsersSimple;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ConsumersMapper {
    @Select("select COUNT(*) from enss.users")
    public Integer count();


    public List<UsersSimple> list(Integer start, Integer pageSize, String userName, LocalDate begin, LocalDate end);

    @Delete("delete from enss.users where enss.users.user_id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into enss.users values (#{userId},#{userName},#{password},#{userPhoto},#{phone},#{userAccount},#{userAddress},#{lastUpdateDate},#{registrationDate})")
    void insert(Users users);

    @Select("select * from enss.users where enss.users.user_id = #{id}")
    Users select(Integer id);

    void update(Users users);
}
