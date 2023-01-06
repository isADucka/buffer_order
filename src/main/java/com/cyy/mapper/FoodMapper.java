package com.cyy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyy.pojo.po.Food;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:54
 */
@Mapper
public interface FoodMapper extends BaseMapper<Food> {

    @Select("select * from tb2_food where kind=#{kind}")
     List<Food> selectByKind(String kind);

    @Update("update tb2_food set food_name=#{foodName},price=#{price}," +
            "picture=#{picture},description=#{description} where food_id=#{foodId}")
     boolean updateFood(Food food);


    boolean insertFood(Food food);
}
