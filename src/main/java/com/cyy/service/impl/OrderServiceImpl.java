package com.cyy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyy.mapper.OrderMapper;
import com.cyy.pojo.po.Order;
import com.cyy.pojo.po.User;
import com.cyy.pojo.vo.Result;
import com.cyy.service.OrderService;
import com.cyy.service.UserService;
import com.oracle.xmlns.internal.webservices.jaxws_databinding.XmlOneway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author isADuckA
 * @Date 2023/1/6 16:42
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private UserService userService;



    @Override
    public Result checkOut(Integer orderId) {
        //结账得有两件事：单未结，账户有钱
        Order order = orderMapper.selectById(orderId);
        if(1==order.getStatus()){
            //返回结账的账户
            return Result.succeedAndaddDate("该单已结账","userId",order.getUserId());
        }
        //查找到对应的账户
        User user = userService.getById(order.getUserId());
        if(user.getMoney()>=order.getPay()){
            boolean b = orderMapper.checkOut(orderId);
            boolean pay = userService.Pay(order.getUserId(), order.getPay());
            System.out.println(b);
            System.out.println(pay);
            if(b&&pay){
                return Result.succeed("结账成功，欢迎下次光临！");
            }else{
                return Result.error("付款失败，等检查设备问题");
            }
        }else{
            return Result.error("余额不足，请充值！");
        }

    }
}
