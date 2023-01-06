package com.cyy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyy.pojo.po.Employee;
import com.cyy.pojo.po.Food;
import com.cyy.pojo.vo.Result;
import com.cyy.service.EmployeeService;
import com.cyy.service.FoodService;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author isADuckA
 * @Date 2023/1/6 19:30
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    LambdaQueryWrapper<Employee> queryWrapper;

    @Autowired
    private EmployeeService employeeService ;


    @DeleteMapping
    public Result delete(Integer bossId,Integer deleteId){
        Employee boss = employeeService.getById(bossId);
        if(boss.getLeader()==1){
            boolean b = employeeService.removeById(deleteId);
            if(b){
                return  Result.succeed("开除成功");
            }else{
                return Result.error("失败，请重试");
            }
        }
        return Result.error("权限不够");
    }

}
