package com.test.pms.mapper;

import com.test.pms.pojo.Administrator;
import com.test.pms.pojo.Department;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Mapper
public interface DepartmentMapper {
    @Select("select * from enss.department")
    List<Department> list();

    @Transactional
    @Delete("delete from enss.department where enss.department.department_id = #{id}")
    void deleteById(Integer id);

    //判断部门是否存在，修改员工的部门


    @Insert("insert into enss.department values (#{departmentId},#{departmentName},#{creationDate},#{lastUpdateDate})")
    void insert(Department department);

    @Select("select * from enss.department where enss.department.department_id = #{id}")
    Department selectById(Integer id);

    void update(Department department);
}
