package com.cyy.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.cyy.pojo.po.User;
import com.cyy.pojo.vo.Result;
import com.cyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:39
 */
@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    LambdaQueryWrapper<User> queryWrapper;

    /**
     * 注册
     * @param user user信息
     * @return Result
     */
    @PostMapping
    public Result register(@RequestBody User user){
        queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,user.getPhone());
        User one = userService.getOne(queryWrapper);
        if(one==null){
            userService.save(user);
            return Result.succeed("注册成功");
        }
        return Result.error("该号码已经被注册过");
    }

    /**
     * 登录
     * @param user 用户信息
     * @return Result
     */
    @PutMapping
    public Result login(@RequestBody User user){
        queryWrapper=new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getPhone,user.getPhone());
        User one = userService.getOne(queryWrapper);
        if(one==null){
            return Result.error("该手机号未注册过");
        }
        if(one.getPassword().equals(user.getPassword())){
            return Result.succeedAndaddDate("登录成功","userId",one.getUserId());
        }
        return Result.error("账号或密码错误!请重试");
    }


    /**
     * 充值
     * @param userId 用户id
     * @param money 充值金额
     * @return Result
     */
    @GetMapping
    public Result topUp(Integer userId,Double money){
        return userService.topUp(userId,money);
    }


}
