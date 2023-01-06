package com.cyy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyy.pojo.po.Food;
import com.cyy.pojo.vo.Result;
import com.cyy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:59
 */
@RestController
@RequestMapping("/food")
public class FoodController {

    @Autowired
    private FoodService foodService;

    LambdaQueryWrapper<Food> queryWrapper;


    /**
     * 展示菜品
     * @param kind 种类名称
     * @return Result
     */
    @GetMapping("/{kind}")
    public Result show(@PathVariable String kind){
        List<Food> foods = foodService.selectByKind(kind);
        if(foods.isEmpty()){
            return Result.error("更多的菜品尽请期待");
        }else{
            return Result.succeedAndaddDate("菜品如下",kind,foods);
        }
    }

    /**
     * 上新食物内容
     * @param food
     */
    @PutMapping
    public Result updateFood(@RequestBody Food food){
        System.out.println(food);
        return foodService.updateFood(food);
    }

    @PostMapping
    public Result insertFood(@RequestBody Food food){
        System.out.println(food);
        boolean save = foodService.save(food);
        if(save){
            return Result.succeed("增加成功");
        }
        return Result.error("请重试");

    }
}
