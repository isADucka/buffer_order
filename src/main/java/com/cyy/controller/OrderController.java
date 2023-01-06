package com.cyy.controller;

import com.cyy.pojo.po.Order;
import com.cyy.pojo.vo.Result;
import com.cyy.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author isADuckA
 * @Date 2023/1/5 16:39
 */
@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 点餐
     * @param order order
     * @return result
     */
    @PostMapping
    public Result orderOne(@RequestBody Order order){
        int count = orderService.count();
        order.setDetails(order.getOrderDetails().toString());
         orderService.save(order);
        return Result.succeedAndaddDate("下单成功","order",order);
    }

    /**
     * 结账
     * @param orderId 餐号
     * @return Result
     */
    @GetMapping("/{orderId}")
    public Result pay(@PathVariable Integer orderId){
        return orderService.checkOut(orderId);
    }



}
