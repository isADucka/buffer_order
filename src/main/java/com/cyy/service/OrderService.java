package com.cyy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyy.pojo.po.Order;
import com.cyy.pojo.vo.Result;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:55
 */
public interface OrderService extends IService<Order> {
    /**
     * 结账
     * @param orderId 取餐号码
     * @return 是或否
     */
     Result checkOut(Integer orderId);
}
