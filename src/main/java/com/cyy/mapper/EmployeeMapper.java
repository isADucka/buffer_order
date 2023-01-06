package com.cyy.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.cyy.pojo.po.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * @author isADuckA
 * @Date 2023/1/6 19:27
 */

@Mapper
public interface EmployeeMapper  extends BaseMapper<Employee> {

}
