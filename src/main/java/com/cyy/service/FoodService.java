package com.cyy.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.cyy.pojo.po.Employee;
import com.cyy.pojo.po.Food;
import com.cyy.pojo.vo.Result;

import java.util.List;
import java.util.Map;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:56
 */
public interface FoodService extends IService<Food> {

    public List<Food> selectByKind(String kind);

    /**
     * 更新菜色
     * @param food food
     * @return Result
     */
    public Result updateFood(Food food);

//    /**
//     * 上新
//     * @param food
//     * @return
//     */
//    public Result insert(Food food);
}
