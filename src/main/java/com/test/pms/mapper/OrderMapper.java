package com.test.pms.mapper;

import com.test.pms.pojo.*;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface OrderMapper {
    @Delete("delete from enss.`order`where enss.`order`.order_id=#{id}")
    void deleteById();

    @Insert("insert into enss.`order` values (#{orderId},#{orderDate},#{totalAmount},#{billingAddress},#{userId},#{lastUpdateDate})")
    void insertOrder(Order order);

    @Insert("insert into enss.order_product values (#{orderProductId},#{orderId},#{productId},#{quantity})")
    void insert(OrderAll orderAll);
    //查找
    @Select("select count(*) from enss.order")
    public Integer count();

    public List<OrderAll> list(Integer start, Integer pageSize, String userName, String productName, LocalDate begin, LocalDate end);

    //修改
    @Select("select * from enss.`order` where enss.`order`.order_id = #{id}")
    public Order selector(Integer id);

    @Select("select enss.order_product.order_product_id,enss.order_product.product_id,enss.order_product.quantity from enss.order_product where enss.order_product.order_id = #{id}")
    public List<OrderProduct> selectOp(Integer id);
    @Select("select * from enss.order_product where enss.order_product.order_product_id = #{id}")
    public OrderProduct selectOpByOpId(Integer id);

    @Select("select enss.products.product_id,enss.products.product_name,enss.products.product_price from enss.products where enss.products.product_id = #{id}")
    public Product selectP(Integer id);

    @Select("select enss.order_product.quantity from enss.order_product where order_product_id = #{id}")
    public Integer selectQua(Integer id);

    void updateOr(Order order);
    void updateOp(Integer productId, Integer quantity);
}
