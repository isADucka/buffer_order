package com.cyy.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyy.pojo.po.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;


/**
 * @author isADuckA
 * @Date 2023/1/5 16:49
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

    @Update("update tb1_user set money=money+${money} where user_id=#{userId}")
    public boolean topUp(Integer userId,Double money);

    @Update("update tb1_user set money=money-${money} where user_id=#{userId}")
    public boolean pay(Integer userId,Double money);

}
