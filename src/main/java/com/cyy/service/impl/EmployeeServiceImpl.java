package com.cyy.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.cyy.mapper.EmployeeMapper;
import com.cyy.mapper.FoodMapper;
import com.cyy.pojo.po.Employee;
import com.cyy.pojo.po.Food;
import com.cyy.pojo.vo.Result;
import com.cyy.service.EmployeeService;
import com.cyy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author isADuckA
 * @Date 2023/1/6 19:29
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements EmployeeService {


}
