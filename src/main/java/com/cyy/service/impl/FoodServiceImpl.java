package com.cyy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyy.mapper.FoodMapper;
import com.cyy.pojo.po.Food;
import com.cyy.pojo.vo.Result;
import com.cyy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author isADuckA
 * @Date 2023/1/6 14:40
 */

@Service
public class FoodServiceImpl extends ServiceImpl<FoodMapper, Food> implements FoodService {

    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<Food> selectByKind(String kind) {
        return foodMapper.selectByKind(kind);
    }


    @Override
    public Result updateFood(Food food) {
//food.getFoodName(),food.getDesc(),food.getPicture(),food.getPrice(),food.getFoodId()
        boolean b = foodMapper.updateFood(food);
        System.out.println(food);
        System.out.println(b);
        if(b){
            return  Result.succeed("修改成功");
        }
        return Result.error("修改失败");
    }

//    @Override
//    public Result insert(Food food) {
//
//    }


}
