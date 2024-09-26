package com.test.pms.mapper;

import com.test.pms.pojo.Administrator;
import com.test.pms.pojo.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface ProductMapper {

    @Delete("delete from enss.products where product_id = #{id}")
    public Integer deleteById(Integer id);

    @Select("select count(*) from enss.products")
    Integer count();
    /*@Select("select *")
    List<Product> list();*/

    public List<Product> list(Integer start, Integer pageSize, String productName, String supplierName, LocalDate begin, LocalDate end);

    @Select("select description from enss.products where product_id=#{id}")
    String selectDes(Integer id);

    //根据id查价格
    @Select("select enss.products.product_price from enss.products where product_id = #{id}")
    Double findPrice(Integer id);

    @Insert("insert into enss.products values (#{productId},#{productName},#{productPrice},#{stockQuantity},#{supplierName},#{lastUpdateDate},#{description})")
    void insert(Product product);

    @Select("select * from enss.products where enss.products.product_id = #{id}")
    public Product selectById(Integer id);

    void update(Administrator administrator);
}
