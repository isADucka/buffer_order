package com.cyy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyy.pojo.po.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.data.relational.core.sql.In;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:53
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Update("update tb3_order set status=1 where order_id=#{orderId}")
    public boolean checkOut(Integer orderId);

    @Select("select user_id,pay,order_id,status from tb3_order where order_id=#{orderId}")
    public Order selectById(Integer orderId);
}
