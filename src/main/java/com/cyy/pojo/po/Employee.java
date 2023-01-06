package com.cyy.pojo.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * @author isADuckA
 * @Date 2023/1/6 19:24
 */
@Data
@TableName("tb4_employee")
public class Employee {

    @TableId(type = IdType.AUTO)
    private Integer employeeId;

    private String phone;

    private String password;

    private Integer leader;
}
