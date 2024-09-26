package com.test.pms.mapper;

import com.test.pms.pojo.Administrator;
import com.test.pms.pojo.Supplier;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SupplierMapper {
    @Select("select * from enss.suppliers")
    List<Supplier> list();

    @Delete("delete from enss.suppliers where supplier_id = #{id}")
    void deleteById(Integer id);

    @Insert("insert into enss.suppliers values (#{supplierId},#{supplierName},#{contactInfo},#{lastUpdateDate})")
    void insert(Supplier supplier);

    @Select("select * from enss.suppliers where enss.suppliers.supplier_id = #{id}")
    Supplier selectById(Integer id);

    void update(Supplier supplier);
}
