package com.cyy.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.cyy.pojo.po.User;
import com.cyy.pojo.vo.Result;

/**
 * @author isADuckA
 * @Date 2023/1/5 16:58
 */
public interface UserService extends IService<User> {

    /**
     * 充值
     * @param userId 用户userId
     * @param money 充值金额
     * @return Result
     */
    Result topUp(Integer userId,Double money);

    /**
     * 付款
     * @param userId 用户id
     * @param moeny 账单金额
     * @return true or false
     */
    boolean Pay(Integer userId,Double moeny);
}
