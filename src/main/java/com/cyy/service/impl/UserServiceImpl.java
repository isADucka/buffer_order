package com.cyy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyy.mapper.UserMapper;
import com.cyy.pojo.po.User;
import com.cyy.pojo.vo.Result;
import com.cyy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author isADuckA
 * @Date 2023/1/6 13:05
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    public UserMapper userMapper;

    @Override
    public Result topUp(Integer userId, Double money) {
        if (money > 0) {
            boolean b = userMapper.topUp(userId, money);
            if (b) {
                return Result.succeed("充值成功");
            } else {
                return Result.error("请检查网络");
            }
        }
        return Result.error("充值失败，请重新输入金额");

    }


    @Override
    public boolean Pay(Integer userId, Double money) {
        boolean b=false;
        if(money>0){
          b = userMapper.pay(userId, money);
        }
        return b;
    }
}
