package com.test.pms.mapper;

import com.test.pms.pojo.Administrator;
import com.test.pms.pojo.Employees;
import com.test.pms.pojo.EmployeesSimple;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmployeesMapper {
    @Delete("delete from enss.employees where enss.employees.employee_id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into enss.employees values (#{employeeId},#{name},#{departmentId},#{age},#{employeePhoto},#{professionalTitle},#{dateOnBoard},#{lastUpdateDate})")
    void insert(Employees employees);

    @Select("select COUNT(*) from enss.employees")
    public Integer count();

    public List<EmployeesSimple> list(Integer page, Integer pageSize, String name, Integer age, String professionalTitle, LocalDate begin, LocalDate end);

    @Select("select * from enss.employees where enss.employees.employee_id = #{id}")
    public Employees select(Integer id);

    void update(Employees employees);
}
